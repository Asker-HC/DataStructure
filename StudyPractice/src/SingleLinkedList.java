import java.util.Stack;

public class SingleLinkedList {
    public static void main(String[] args) {
        SingleLinked singleLinked1 = new SingleLinked();
        SingleLinked singleLinked2 = new SingleLinked();
        Node node1 = new Node(new Hero(1, "宋江", "及时雨"), null);
        Node node2 = new Node(new Hero(2, "卢俊义", "玉麒麟"), null);
        Node node3 = new Node(new Hero(3, "吴用", "智多星"), null);
        Node node4 = new Node(new Hero(4, "林冲", "豹子头"), null);
        Node node5 = new Node(new Hero(5, "武松", "行者"), null);
        Node node6 = new Node(new Hero(6, "鲁智深", "花和尚"), null);
        Node node7 = new Node(new Hero(3, "没用", "智多星"), null);
        System.out.println("--------------排序添加-------------");
        singleLinked1.addOrder(node2);
        singleLinked1.addOrder(node3);
        singleLinked1.addOrder(node1);
        singleLinked2.addOrder(node6);
        singleLinked2.addOrder(node4);
        singleLinked2.addOrder(node5);
        singleLinked1.showAllNode();
        System.out.println("---------------------------");
        singleLinked2.showAllNode();
       /* System.out.println("---------------两个有序单链表合并------------");
        SingleLinked mergeOrder = mergeOrder(singleLinked1.getHeadNode(), singleLinked2.getHeadNode());
        mergeOrder.showAllNode();*/
        System.out.println("---------------修改------------");
        singleLinked1.update(node7);
        singleLinked1.showAllNode();
        System.out.println("---------------删除------------");
        singleLinked1.delete(2);
        singleLinked1.showAllNode();
        System.out.println("---------------统计------------");
        int count = getCount(singleLinked1);
        System.out.println(count);
        System.out.println("---------------反转1------------");
        SingleLinked reverse = reverse1(singleLinked1);
        reverse.showAllNode();
        System.out.println("---------------反转2------------");
        reverse2(singleLinked1.getHeadNode());
        reverse.showAllNode();
        System.out.println("---------------递归逆序打印------------");
        showReverse(singleLinked1.getHeadNode());
        System.out.println("---------------栈方式逆序打印------------");
        showReverseStack(singleLinked1.getHeadNode());
    }

    /**
     * 获取单链表中有效数据个数(不包括头节点)
     *
     * @param singleLinked
     * @return
     */
    public static int getCount(SingleLinked singleLinked) {
        Node temp = singleLinked.getHeadNode();
        if (temp.getNext() == null) {
            return 0;
        }
        int result = 0;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            result++;
            temp = temp.getNext();
        }
        return result;
    }

    /**
     * 单链表反转(方法1：三指针)
     *
     * @param singleLinked
     * @return
     */
    public static SingleLinked reverse1(SingleLinked singleLinked) {
        Node temp0 = singleLinked.getHeadNode();
        Node temp = temp0.getNext();
        Node temp1 = temp.getNext();
        if (temp == null || temp1 == null) {
            return singleLinked;
        }
        while (true) {
            Node temp2 = temp1.getNext();
            temp1.setNext(temp);
            temp = temp1;
            temp1 = temp2;
            if (temp1 == null) {
                temp0.getNext().setNext(null);
                temp0.setNext(temp);
                return singleLinked;
            }
        }
    }

    /**
     * 单链表反转（方法2：辅助链表头）
     *
     * @param head
     * @return
     */
    public static void reverse2(Node head) {
        Node temp = head.getNext();
        Node reverseHead = new Node();
        Node curr = null;
        if (temp.getNext() == null || temp.getNext().getNext() == null) {
            return;
        }
        while (temp != null) {
            curr = temp.getNext();
            temp.setNext(reverseHead.getNext());
            reverseHead.setNext(temp);
            temp = curr;
        }
        head.setNext(reverseHead.getNext());
    }

    /**
     * 递归倒序打印单链表
     *
     * @param head
     */
    public static void showReverse(Node head) {
        Node temp = head;
        if (temp.getNext() == null) {
            return;
        } else {
            temp = temp.getNext();
            showReverse(temp);
            System.out.println(temp);
        }
    }

    /**
     * 采用栈实现单链表的逆序输出
     *
     * @param head
     */
    public static void showReverseStack(Node head) {
        Node temp = head.getNext();
        Stack<Node> stack = new Stack<Node>();
        while (temp != null) {
            stack.add(temp);
            temp = temp.getNext();
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序单链表
     *
     * @param head1
     * @param head2
     * @return
     */
    public static SingleLinked mergeOrder(Node head1, Node head2) {
        SingleLinked mergeResult = new SingleLinked();
        Node temp1 = head1.getNext();
        Node temp2 = head2.getNext();
        return mergeResult;
    }
}

class SingleLinked {
    private Node headNode = new Node(null, null);

    public void addNode(Node node) {
        Node temp = headNode;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void addOrder(Node node) {
        Node temp = headNode;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                break;
            } else {
                if (temp.getNext().getHero().getNum() >= node.getHero().getNum()) {
                    node.setNext(temp.getNext());
                    temp.setNext(node);
                    break;
                } else {
                    temp = temp.getNext();
                }
            }
        }
    }

    public void delete(int num) {
        if (headNode.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = headNode;
        while (true) {
            if (temp.getNext().getHero().getNum() == num) {
                temp.setNext(temp.getNext().getNext());
                break;
            }
            temp = temp.getNext();
        }
    }

    public void update(Node node) {
        if (headNode.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = headNode;
        while (true) {
            if (node.getHero().getNum() == temp.getNext().getHero().getNum()) {
                node.setNext(temp.getNext().getNext());
                temp.setNext(node);
                break;
            }
            temp = temp.getNext();
        }
    }

    public void showAllNode() {
        if (headNode.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = headNode;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
            System.out.println(temp);
        }
    }

    public Node getHeadNode() {
        return headNode;
    }

}

class Node {
    private Hero hero;
    private Node next;

    public Node() {
    }

    public Node(Hero hero, Node next) {
        this.hero = hero;
        this.next = next;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "hero=" + hero + "}";
    }
}

class Hero {
    private int num;
    private String name;
    private String nickName;

    public Hero() {
    }

    public Hero(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
