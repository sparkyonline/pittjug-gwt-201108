package net.stackdump.example.gwt.gwtexample.server;

import static net.stackdump.example.gwt.gwtexample.shared.data.SessionType.Exclusive;
import static net.stackdump.example.gwt.gwtexample.shared.data.SessionType.Pooled;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.BooleanUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import net.stackdump.example.gwt.gwtexample.shared.data.Emulator;
import net.stackdump.example.gwt.gwtexample.shared.data.Instance;
import net.stackdump.example.gwt.gwtexample.shared.data.Organization;
import net.stackdump.example.gwt.gwtexample.shared.data.Property;
import net.stackdump.example.gwt.gwtexample.shared.data.Session;
import net.stackdump.example.gwt.gwtexample.shared.data.SessionPool;
import net.stackdump.example.gwt.gwtexample.shared.data.SessionType;
import net.stackdump.example.gwt.gwtexample.shared.data.TimeType;

/**
 * Retrieves stats for an instance.
 */
public class InstanceStatusRetriever
{
    private static final Map<String, SessionType> sessionTypeLookup;
        
    static
    {
        final Map<String, SessionType> map =
            new HashMap<String, SessionType>(SessionType.values().length);
        map.put(Exclusive.toString(), Exclusive);
        map.put(Pooled.toString(), Pooled);
        
        sessionTypeLookup = Collections.unmodifiableMap(map);
    }
    
    /**
     * Get the status for an instance.
     * 
     * @return The status.
     */
    public Instance getInstanceStatus()
    {
        final Document doc = getXML();
        final XPath serverPath =
            DocumentHelper
                .createXPath("/XMLAPI/MESSAGE/SYSTEMSTATUS/RESPONSE/Server");
        final Node serverNode = serverPath.selectSingleNode(doc);
        final Instance instance = new Instance();
        
        populateInstance(serverNode, instance);
        
        return instance;
    }
    
    /**
     * Populates status for the given instance.
     * 
     * @param server The server-level status XML node.
     * @param instance The object to populate.
     */
    private void populateInstance(Node server, final Instance instance)
    {
        instance.setID(server.valueOf("@id"));
        instance.setName(server.valueOf("Name"));
        instance.setAddress(server.valueOf("Address"));
        instance.setVersion(server.valueOf("Version"));
        instance.setWebContainer(server.valueOf("WebContainer"));
        instance.getTimes().put(TimeType.Creation,
            server.numberValueOf("CreationTime").longValue());
        instance.getTimes().put(TimeType.Report,
            server.numberValueOf("ReportTime").longValue());
        
        final Node config = server.selectSingleNode("Config");
        populateConfig(config, instance.getConfig());
        
        final Node orgs = server.selectSingleNode("Organizations");
        populateOrgs(orgs, instance.getOrganizations());
    }
    
    private void populateConfig(Node config, final Map<String, Property> map)
    {
        final List<?> nodes = config.selectNodes("Property");
        
        Node node;
        String key;
        Property prop;
        for (Object nodeObj : nodes)
        {
            node = (Node) nodeObj;
            prop = new Property();
            prop.setDynamic(BooleanUtils.toBoolean(node.valueOf("@dynamic")));
            key = node.valueOf("@name");
            prop.setName(key);
            prop.setConfigurable(BooleanUtils.toBoolean(node
                .valueOf("@configurable")));
            prop.setValue(node.getStringValue());
            map.put(key, prop);
        }
    }
    
    private void populateOrgs(final Node orgs, final List<Organization> list)
    {
        final List<?> nodes = orgs.selectNodes("Organization");
        
        Node node;
        Organization org;
        for (Object nodeObj : nodes)
        {
            node = (Node) nodeObj;
            org = new Organization();
            
            org.setID(node.valueOf("@id"));
            org.setName(node.valueOf("Name"));
            
            final Node sessions = node.selectSingleNode("Sessions");
            if (sessions != null)
            {
                populateSessions(sessions, org.getSessions());
            }
            
            final Node sessionPools = node.selectSingleNode("SessionPools");
            if (sessionPools != null)
            {
                populateSessionPools(sessionPools, org.getSessionPools());
            }
            
            list.add(org);
        }
    }
    
    private void populateSessionPools(final Node sessionPools,
        final List<SessionPool> list)
    {
        final List<?> nodes = sessionPools.selectNodes("SessionPool");
        
        Node node;
        SessionPool pool;
        Node sessions;
        for (Object nodeObj : nodes)
        {
            node = (Node) nodeObj;
            pool = new SessionPool();
            
            pool.setID(node.valueOf("@id"));
            pool.setName(node.valueOf("Name"));
            pool.setMaxSize(node.numberValueOf("MaxSize").longValue());
            pool.setMinSize(node.numberValueOf("MinSize").longValue());
            pool.setInactivityTimeout(node.numberValueOf("InactivityTimeout")
                .longValue());
            pool.setNumWaiters(node.numberValueOf("NumWaiters").longValue());
            pool.setTotalWaiters(node.numberValueOf("TotalWaiters").longValue());
            pool.setMaxWaitTime(node.numberValueOf("MaxWaitTime").longValue());
            pool.setTotalThreads(node.numberValueOf("TotalThreads").longValue());
            pool.setAverageWaitTime(node.numberValueOf("AverageWaitTime")
                .longValue());
            
            sessions = node.selectSingleNode("Sessions");
            if (sessions != null)
            {
                populateSessions(sessions, pool.getSessions());
            }
            
            list.add(pool);
        }
    }
    
    private void populateSessions(final Node sessions, final List<Session> list)
    {
        final List<?> nodes = sessions.selectNodes("Session");
        
        Node node;
        Session session;
        for (Object nodeObj : nodes)
        {
            node = (Node) nodeObj;
            session = new Session();
            
            session.setID(node.valueOf("@id"));
            session.setName(node.valueOf("Name"));
            session.setType(sessionTypeLookup.get(node.valueOf("Type")));
            session.setStatus(node.valueOf("Status"));
            session.getTimes().put(TimeType.Creation,
                node.numberValueOf("CreationTime").longValue());
            session.getTimes().put(TimeType.LastAccess,
                node.numberValueOf("LastAccessTime").longValue());
            session.setInactivityTimeout(node
                .numberValueOf("InactivityTimeout").longValue());
            
            final Node emus = node.selectSingleNode("Emulators");
            if (emus != null)
            {
                populateEmulators(emus, session.getEmulators());
            }
            
            list.add(session);
        }
    }
    
    private void populateEmulators(final Node emus, final List<Emulator> list)
    {
        final List<?> nodes = emus.selectNodes("Emulator");
        
        Node node;
        Emulator emu;
        for (Object nodeObj : nodes)
        {
            node = (Node) nodeObj;
            emu = new Emulator();
            
            emu.setID(node.valueOf("@id"));
            emu.setSystem(node.valueOf("System"));
            emu.setCurrentScreen(node.valueOf("CurrentScreen"));
            emu.getTimes().put(TimeType.Creation,
                node.numberValueOf("CreationTime").longValue());
            emu.getTimes().put(TimeType.LastAccess,
                node.numberValueOf("LastAccessTime").longValue());
            emu.setTerminalID(node.valueOf("TerminalId"));
            emu.setNodeName(node.valueOf("NodeName"));
            
            list.add(emu);
        }
    }
    
    /**
     * Get the XML containing the status.
     * 
     * @return The XML.
     */
    private Document getXML()
    {
        Document doc = null;
        
        InputStream is = null;
        try
        {
            is = getClass().getResourceAsStream("test-status.xml");
            doc = new SAXReader().read(is);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            IOUtils.closeQuietly(is);
        }
        
        return doc;
    }
}
