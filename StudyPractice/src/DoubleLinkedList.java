public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinked doubleLinked = new DoubleLinked();
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨",null,null);
        HeroNode node2 = new HeroNode(2, "卢俊义", "玉麒麟",null,null);
        HeroNode node3 = new HeroNode(3, "吴用", "智多星",null,null);
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头",null,null);
        HeroNode node5 = new HeroNode(5, "武松", "行者",null,null);
        HeroNode node6 = new HeroNode(6, "鲁智深", "花和尚",null,null);
        System.out.println("--------------添加-------------");
        doubleLinked.add(node3);
        doubleLinked.add(node5);
        doubleLinked.add(node1);
        doubleLinked.add(node2);
        doubleLinked.add(node6);
        doubleLinked.add(node4);
        doubleLinked.show();
        System.out.println("--------------删除-------------");
        doubleLinked.delete(2);
        doubleLinked.show();
        System.out.println("--------------修改-------------");
        HeroNode node7 = new HeroNode(1, "宋江", "呼保义",null,null);
        doubleLinked.update(node7);
        doubleLinked.show();
        System.out.println("--------------查询-------------");
        HeroNode query = doubleLinked.query(5);
        System.out.println(query);
    }
}


class DoubleLinked {
    private HeroNode head = new HeroNode();

    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }

    public void delete(int num){
        HeroNode temp = head.getNext();
        while (temp != null) {
            if (temp.getNum() == num){
               temp.getPre().setNext(temp.getNext());
            }
            temp = temp.getNext();
        }
    }

    public void update(HeroNode heroNode){
        HeroNode temp = head.getNext();
        while (temp != null) {
            if (temp.getNum() == heroNode.getNum()){
               temp.setName(heroNode.getName());
               temp.setNackName(heroNode.getNackName());
               return;
            }
            temp = temp.getNext();
        }
    }

    public HeroNode query(int num){
        HeroNode temp = head.getNext();
        while (temp != null) {
            if (temp.getNum() == num){
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void show(){
        HeroNode temp = head.getNext();
        while (temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class HeroNode {
    private int num;
    private String name;
    private String nackName;
    private HeroNode pre;
    private HeroNode next;

    public HeroNode() {
    }

    public HeroNode(int num, String name, String nackName, HeroNode pre, HeroNode next) {
        this.num = num;
        this.name = name;
        this.nackName = nackName;
        this.pre = pre;
        this.next = next;
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

    public String getNackName() {
        return nackName;
    }

    public void setNackName(String nackName) {
        this.nackName = nackName;
    }

    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nackName='" + nackName + '\'' +
                '}';
    }
}