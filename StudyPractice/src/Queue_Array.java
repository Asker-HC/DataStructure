import java.util.Scanner;

public class Queue_Array {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("-------------------------");
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head): 查看队头");
            key = scanner.next().charAt(0);
            switch(key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入数据：");
                    int data = scanner.nextInt();
                    arrayQueue.addData(data);
                    break;
                case 'g':
                    try {
                        int value = arrayQueue.getData();
                        System.out.println("取出的数据是："+value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int value = arrayQueue.headQueue();
                        System.out.println("队列头部数据是："+value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序已退出。。。");
    }
}

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public ArrayQueue(int maxSize) {
        this.array = new int[maxSize];
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void addData(int data) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        array[rear] = data;
        System.out.println("添加成功");
    }

    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        } else {
            front++;
            return array[front];
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("arr[%d]=%d\n", i, array[i]);
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return array[front + 1];
    }
}