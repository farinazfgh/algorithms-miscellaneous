import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.*;


public class XmlTree {
    static TreeNode root;

    static class TreeNode {
        public int data;
        public String text;
        public List<TreeNode> Children = new ArrayList<TreeNode>();

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(String text) {
            this.text = text;
        }

        public static void display_level_order(TreeNode root) {
            if (root == null)
                return;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode tempNode = new TreeNode(100);
            queue.offer(tempNode);

            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();

                if (temp == tempNode) {
                    System.out.println();
                    if (!queue.isEmpty()) {
                        queue.offer(tempNode);
                        continue;
                    } else {
                        return;
                    }

                }

                System.out.print(temp.data + ", ");

                for (int i = 0; i < temp.Children.size(); i++) {
                    queue.offer(temp.Children.get(i));
                }
            }
            System.out.println();
        }
    }


    public static TreeNode createXmlTree(String xml) throws XMLStreamException {
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(is);
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode last = null;
        while (reader.hasNext()) {
            if (reader.getEventType() == XMLStreamConstants.START_DOCUMENT ||
                    reader.getEventType() == XMLStreamConstants.SPACE ||
                    reader.getEventType() == XMLStreamConstants.END_DOCUMENT) {
                reader.next();
                continue;
            } else if (reader.getEventType() == XMLStreamConstants.END_ELEMENT) {
                if (!stack.empty()) {
                    last = stack.pop();
                }
                reader.next();
                continue;
            }

            if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                TreeNode node = new TreeNode(reader.getLocalName());

                if (!stack.empty()) {
                    stack.peek().Children.add(node);
                }

                stack.push(node);
            } else if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                TreeNode node = new TreeNode(reader.getText());

                if (!stack.empty()) {
                    stack.peek().Children.add(node);
                }
            }

            reader.next();
        }
        return last;
    }

    public static void print_tree(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < depth; ++i) System.out.print("\t");
        System.out.print(root.text + "\n");
        for (TreeNode child : root.Children) {
            print_tree(child, depth + 1);
        }
    }

 /*   public static void main(String[] args) {
        try {
            String xml = "<html><body><div><h1>CodeRust</h1><a>http://coderust.com</a></div><div><h2>Chapter1</h2></div><div><h3>Chapter2</h3><h4>Chapter2.1</h4></div></body></html>";
            TreeNode result = createXmlTree(xml);
            print_tree(result, 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/

    public static TreeNode createXmlTreeF(String xml) {
        Stack<TreeNode> stack = new Stack<>();
        char[] xmlStr = xml.toCharArray();
        for (int i = 0; i < xmlStr.length; i++) {
            StringBuilder sb = new StringBuilder();

            if (xmlStr[i] == '<') {
                while (xmlStr[i] != '>') {
                    sb.append(xmlStr[i]);
                    i++;
                }
                TreeNode node = new TreeNode(sb.toString());
                if (root == null) root = node;
                else {
                    TreeNode parent = stack.peek();
                    parent.Children.add(node);
                }
                stack.push(node);
            } else if (xmlStr[i] == '/') {
                stack.pop();
            } else {
                while (xmlStr[i + 1] != '/') {
                    sb.append(xmlStr[i]);
                    i++;
                }
                TreeNode node = new TreeNode(sb.toString());
                if (root == null) root = node;
                TreeNode parent = stack.peek();
                if (parent != null)
                    parent.Children.add(node);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        createXmlTreeF("<html><body><div><h1>CodeRust</h1><a>http://coderust.com</a></div><div><h2>Chapter1</h2></div><div><h3>Chapter2</h3><h4>Chapter2.1</h4></div></body></html>");
    }
}