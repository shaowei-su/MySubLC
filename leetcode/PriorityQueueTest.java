package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * PriorityQueue(优先队列)使用完整示例
 * 采用PriorityQueue时里面的每个元素按照一定标准的优先级进行存储.
 * 而这个优先级的标准我们可以用Comparator来自己定义.
 * 
 * 参考资料:
 * 1 http://blog.csdn.net/chengyingzhilian/article/details/8078032
 * 2 http://java-er.com/blog/java-priority-queue/
 * 3 http://blog.csdn.net/hantiannan/article/details/7623108
 *   Thank you very much
 * 
 */
public class PriorityQueueTest {
	private int initialCapacity=10;
	public static void main(String[] args) {
		PriorityQueueTest priorityQueueTest=new PriorityQueueTest();
		priorityQueueTest.test();
	}
	
	
	/**
	 * 将一群斑马放入优先队列PriorityQueue中.
	 * 既然是优先队列PriorityQueue,那么就有一个优先的标准.
	 * 在此就按照每个斑马的身高优先将一群斑马存在队列中
	 */
	private void test(){
		PriorityQueue<Zebra> priorityQueue=new PriorityQueue<Zebra>(initialCapacity, new ZebraComparator());
		Zebra zebra1=new Zebra("a", 130);
		priorityQueue.add(zebra1);
		Zebra zebra2=new Zebra("b", 130);
		priorityQueue.add(zebra2);
		Zebra zebra3=new Zebra("c", 130);
		priorityQueue.add(zebra3);
		Zebra zebra4=new Zebra("d", 130);
		priorityQueue.add(zebra4);
		Zebra zebra5=new Zebra("a", 110);
		priorityQueue.add(zebra5);
		Zebra zebra6=new Zebra("c", 120);
		priorityQueue.add(zebra6);
		
		System.out.println("priorityQueue.size()="+priorityQueue.size());
		
		//每个元素依次出队,便于测试
		while (!priorityQueue.isEmpty()){
		     System.out.println(priorityQueue.poll());
		}
		
		System.out.println("priorityQueue.size()="+priorityQueue.size());
		
	}
	

	//按照斑马的身高进行排序,身高相同时再比较名字
	class ZebraComparator implements Comparator {
		@Override
		public int compare(Object arg0, Object arg1) {
			Zebra zebra0 = (Zebra) arg0;
			Zebra zebra1 = (Zebra) arg1;
			if (zebra0.getHeight() > zebra1.getHeight()) {
				return 1;
			}
			// 身高相同时再比较名字
			if (zebra0.getHeight() == zebra1.getHeight()) {
				return zebra0.getName().compareTo(zebra1.getName());
			}

			if (zebra0.getHeight() < zebra1.getHeight()) {
				return -1;
			}

			return 0;
		}

	}
	
	
	
	/**
	 * 动物园里的大熊猫和斑马还是很可爱的。
	 * 看大熊猫的话,成都熊猫基地很爽.
	 * 看斑马的话,北京动物园不错,里面还有需要仰着脖子看的长颈鹿......
	 * 在这里就用斑马举例吧,它有名字和身高这两个属性
	 */
	private class Zebra{
		private String name;
		private int height;
	
		public Zebra(String name, int height) {
			super();
			this.name = name;
			this.height = height;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}

		@Override
		public String toString() {
			return "Zebra [name=" + name + ", height=" + height + "]";
		}
		
	}

}
