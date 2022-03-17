import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        CirArrayQueue cirArrayQueue = new CirArrayQueue(5);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("-------------------------");
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据");
            System.out.println("g(get): 取出数据");
            System.out.println("h(head): 查看队头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    cirArrayQueue.showQueue();
                    System.out.println("-------------------------");
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入数据：");
                    int data = scanner.nextInt();
                    cirArrayQueue.setData(data);
                    break;
                case 'g':
                    try {
                        int value = cirArrayQueue.getData();
                        System.out.println("取出的数据是：" + value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int value = cirArrayQueue.showHeadQueue();
                        System.out.println("队列头部数据是：" + value);
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

class CirArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] array;

    public CirArrayQueue(int maxSize) {
        this.array = new int[maxSize];
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void setData(int data) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        array[rear] = data;
        rear = (rear + 1) % maxSize;
        System.out.println("添加成功");
    }

    public int getData() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        } else {
            int data = array[front];
            front = (front + 1) % maxSize;
            return data;
        }
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        int currentSize = getCurrentSize();
        for (int i = front; i < front + currentSize; i++) {
            System.out.printf("arr[%d]=%d\t", i % maxSize, array[i % maxSize]);
        }
    }

    public int showHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return array[front];
    }

    public int getCurrentSize() {
        return (rear - front + maxSize) % maxSize;
    }
}
