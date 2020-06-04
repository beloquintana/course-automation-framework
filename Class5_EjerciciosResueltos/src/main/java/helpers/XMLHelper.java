package helpers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLHelper {
    private Document xmlDocument;

    public void readXMLFile(String xmlFilePath) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        xmlDocument = dBuilder.parse(fXmlFile);
    }

    public String getTestData(String testName, String dataName){
        NodeList nodeList = xmlDocument.getElementsByTagName("test");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if(element.getAttribute("name").equals(testName)){
                    return element.getElementsByTagName(dataName).item(0).getTextContent();
                }
            }
        }
        return "";
    }
}
