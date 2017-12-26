/**
 * 
 */
package com.lvhongbin.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import com.mysql.fabric.Response;
import com.opensymphony.xwork2.inject.Context;
import com.sun.corba.se.spi.orbutil.fsm.State;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import antlr.collections.impl.Vector;
import freemarker.core.ReturnInstruction.Return;
import freemarker.template.utility.Execute;
import sun.security.x509.SubjectAlternativeNameExtension;

/**
 * @author hblvs
 *
 */

	
public class TestDesignPattern {
		
}

//抽象产品类
	public abstract class Product{
		
		//产品类的公共方法
		public void method1(){
			
		}
		//抽象方法
		public abstract void method2();
	}

//具体产品类
	public class ConcreteProduct1 extends Product {
		public void method1(){
			//具体的业务处理
		}

		@Override
		public void method2() {
			// TODO Auto-generated method stub
			
		}
	}
	public class ConcreteProduct2 extends Product {
		public void method1(){
			//具体的业务处理
		}

		@Override
		public void method2() {
			// TODO Auto-generated method stub
			
		}
	}

//抽象工厂：
	public abstract class Centor{
		public abstract <T extends Product> T createProduct(Class<T> c);
	}		
		
//具体工厂：
	public  class ConcreteCentor extends Centor{
		@SuppressWarnings("unchecked")
		public  <T extends Product> T createProduct(Class<T> c) {
			Product product=null;
			try {
				product=(Product)Class.forName(c.getName()).newInstance();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return (T)product; 
		}
	}

//场景类
	public class Client{
		public static void main(String[] arg) {
			Centor center=new ConcreteCentor();
			Product product=center.createProduct(ConcreteProduct1.class);
			product.method1();
		}
	}
	
//模板方法
	public abstract class AbstractClass{
		//基本方法
		protected abstract void doSomething();
		protected abstract void doAnything();
		//模板方法
		public void templateMethod() {
			this.doSomething();
			this.doAnything();
		}
	}
	
//抽象主题类
	public interface Subject{
		public void request();
	}

//真实主题类
	public class RealSubject extends Subject{
		public void request() {
			//具体的逻辑业务
		}
	}

//代理类
	public class Proxy extends Subject{
		private Subject subject=null;
		public Proxy(){
			this.subject=new Proxy();
		}
		public Proxy(Object object){
			this.subject=object;
		}
		public void request() {
			this.before();
			this.subject.request();
			this.after();
		}
		public void before() {
			//预处理
		}
		public void after() {
			//后处理
		}
		
	}
	
//抽象主题类
	public interface Subject{
		
		public void doSomething(String str);
	}

//真实主题类
	public class RealSubject extends Subject{
		public void doSomething(String str) {
			//具体的逻辑业务
			System.out.println("do something"+str);
		}
	}
		
//动态代理的Handler类
	public class MyInvocationHandler implements InvocationHandler{

		//被代理的数传递一个参数
		public MyInvoc对象
		private Object target=null;
		//通过构造函ationHandler(Object object) {
			this.target=object;
		}
		
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(this.target, args);
	}		
}
	
//动态代理类
	public class DynamicProxy<T>{
		public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
			//寻找JointPoint连接点，AOP框架使用元数据定义
			//getClassLoader()：取得该Class对象的类装载器类装载器负责从Java字符文件将字符流读入内存
			//并构造Class类对象，在你说的问题哪里，通过它可以得到一个文件的输入流getClass :
			if(true) {
				//执行一个前置通知 
				(new BeforeAdvice()).exec();
			}
			return (T)Proxy.newProxyInstance(loader, interfaces, h);
		}
	} 

//通知接口及实现
	public interface IAdvice{
		public void exec();
	}
	
	public class BeforeAdvice extends IAdvice{
		
		public void exec() {
			System.out.println("我是前置通知，我被执行了！");
		}
	}
	
//动态代理的场景类
	public class Client{
		
		public static void main (string[] avgs) {
			//定义一个主题
			Subject subject=new RealSubject;
			//定义了一个Hander类
			InvocationHandler handle=new MyInvocationHandler();
			//定义主题的代理
			Subject proxy =DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),
					subject.getClass().getInterfaces(),handle);
			proxy.doSomething("Finish");
		}
		
	}
	
	
	
//原型模式
	public class PrototypeClass implements Cloneable{
		
		@Override
		public PrototypeClass clone() {
			PrototypeClass prototypeClass=null;
			try {
				prototypeClass=(PrototypeClass)super.clone();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return prototypeClass;
		}
	}


//抽象接收者
	public abstract class Reciver{
		public abstract doSomething();
	}
	
//具体接收者1
	public class Reciver1 extends Reciver{
		public void doSomething() {
		}
	}

//具体接收者2
	public class Reciver2 extends Reciver{
		public void doSomething() {
		}
	}

//抽象命令
	public abstract class Command{
		public abstract void execute();
	}

//具体命令
	public class Delete extends Command{
		private Reciver reciver=null;

		/**
		 * @param reciver the reciver to set
		 */
		public void setReciver(Reciver reciver) {
			this.reciver = reciver;
		}
		public abstract void execute() {
			this.reciver.doSomething();
		}
	}
	
	public class Copy extends Command{
		private Reciver reciver=null;

		/**
		 * @param reciver the reciver to set
		 */
		public void setReciver(Reciver reciver) {
			this.reciver = reciver;
		}
		public abstract void execute() {
			this.reciver.doSomething();
		}
	}
	
//执行者
	public class Invoker{
		public Command command=null;
		
		/**
		 * @param command the command to set
		 */
		public void setCommand(Command command) {
			this.command = command;
		}
		
		public void action() {
			this.command.execute();
		}
	} 
	
//场景类
	public class Client{
		Command command=new Copy();
		Reciver reciver=new Reciver1();
		command.setReciver(reciver);
		Invoker invoker=new Invoker();
		invoker.setCommand(command);
		invoker.action();	
	}
	

//抽象处理者
	public abstract class Handler{
		
		private Handler nextHandler;
		public void setNext(Handler handler) {
			this.nextHandler=handler;
		}
		public static Response handleMessage(Request request) {
			Response response=null;
			if(this.getHandlerLever.equal(request.getRequestLevel)) {
				response=this.echo(request);
			}else {
				if(this.nextHandler !=null) {
					response=this.nextHandler.handleMessage(request);
				}else {
					
				}
			}
			return response;
		}
		
		protected abstract Level getHandlerLever();
		protected abstract Response echo(Request request);
	}
	
//具体处理者
	public class ConcreteHandler1 extends Handler{
		protected Response echo(Request request) {
			//完成逻辑的处理
			return null;
		}
		protected Lever getHandLerLever() {
			//设置自己的级别
			return null;
		}
	}
	
	public class ConcreteHandler2 extends Handler{
		protected Response echo(Request request) {
			//完成逻辑的处理
			return null;
		}
		protected Lever getHandLerLever() {
			//设置自己的级别
			return null;
		}
	}	

	public class ConcreteHandler3 extends Handler{
		protected Response echo(Request request) {
			//完成逻辑的处理
			return null;
		}
		protected Lever getHandLerLever() {
			//设置自己的级别
			return null;
		}
	}	
	
//相关框架代码
	public class Level{
		//定义一个请求和处理登记;
	}
	
	public class Request{
		//请求的等级
		public Level getRequestLevel() {
			return null;
		}
	}
	
	public class Reponse{
		//处理者返回的数据
	}
	
//场景类
	public class Client{
		public static void main(Static[] args) {
			Handler handler1 =new ConcreteHandler1();
			Handler handler2 =new ConcreteHandler2();
			Handler handler3 =new ConcreteHandler3();
			handler1.setNext(handler2);
			handler2.setNext(handler3);
			Response response = handler1.handlerMessage(new Request());
		}
		
	}
	

//抽象的策略角色
	public interface Strategy{
		public void doSomething();
	}
	
//具体的策略角色	
	public class ConcreteStrategy1 extends Strategy{
		public void doSomething() {
			System.out.println("具体策略一");
		}
	}
	
	public class ConcreteStrategy2 extends Strategy{
		public void doSomething() {
			System.out.println("具体策略二");
		}
	}
	
//封装角色
	public class Content{
		private Strategy strategy;
		public Content(Strategy strategy){
			this.strategy=strategy;
		}
		public void doAnything() {
			this.strategy.doSomething();
		}
	}
	
//高层模块
	public class Client{
		public static void main(String[] args) {
			Strategy strategy=new ConcreteStrategy1;
			Content content=new Content(strategy);
			content.doAnything;
		}
		
	}


//目标角色
	public interface Target{
		public void Request();
	}
	
//目标角色的实现类
	public class ConcreteTarget implements Target{
		public void Request() {
			System.out.println("If you need help, Please call me.");
		};
	}	

//源角色
	public class Adaptee{
		public void doSomething() {
			System.out.println("I'm kind of buzy,leave me alone,ple.");
		}
	}

//适配器角色
	public class Adapter extends Adaptee implements Target{
		@Override
		public void Request() {
			super.doSomething();			
		}
	}

//场景类/高层类
	public class Client{
		public static void main(string[] args) {
			//原有的业务逻辑
			Target target1=new ConcreteTarget();
			Target1.Request();
			//现在增加适配器角色后
			Target target2=new ConcreteTarget();
			Target2.Request();
			
			
		}
		
	}
	
	
	
//抽象迭代器
	public interface Iterator{
		public Object next();
		public boolean hasNext();
		public boolean remove();		
	}
	
//具体迭代器	
	public class ConcreteIterator implements Iterator{
		private Vector vector=new Vector();
		//定义当前游标
		public int cursor=0;
		
		public ConcreteIterator(Vector vector) {
			this.vector=vector;
		}
				

	@Override
	public Object next() {
		Object result=null;
		if(hasNext()) {
			result=this.vector.get(this.cursor++);
		}else {
			result=null;
		}
		return result;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(this.cursor==vector.size()) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean remove() {
		// TODO Auto-generated method stub
		return false;
	}	
}
	
//抽象容器
	public interface Aggregate{
		public void add(Object object);
		public void remove(Object object);
		public Iterator iterator();
	}
	
//具体容器
	public class ConcreteAggregate implements Aggregate {
		
		private Vector vector=null; 
	
		@Override
		public void add(Object object) {
			this.vector.add(object);
			
		}
	
		@Override
		public void remove(Object object) {
			this.vector.remove(object);
			
		}
	
		@Override
		public Iterator iterator() {
			// TODO Auto-generated method stub
			return new ConcreteIterator(this.vector);
		}	
	}
	
	//场景类
		public class Client{
			
			public static void main(String[] args) {
				Aggregate aggregate=new ConcreteAggregate;
				aggregate.add("abc");
				aggregate.add("def");
				aggregate.add("ghi");
				Iterator iterator=aggregate.iterator();
				while (iterator.hasNext()) {
					System.out.println(iterator.next());
				}
			}	
		}	
	
//抽象构建角色
		public interface Component{
			public void doSomething();
		}

//抽象树叶角色
		public interface class AbstractLeaf implements Component{
			public void doSomething();
		}

//抽象树枝角色
		public interface AbstractComposite implements Component{
			public void add(Component component);
			public void remove(Component component);
			public ArrayList<Component> getChildren();	
			public void doSomething() {
			};
		}
//树叶构建
		public class Leaf implements AbstractLeaf{

			@Override
			public void doSomething() {
				// TODO Auto-generated method stub
				
			}
		}
	
//树枝构建
		public class Composite implements AbstractComposite{
			
			ArrayList<Component> arrayList=new ArrayList<Component>();

			@Override
			public void add(Component component) {
				this.arrayList.add(component);
			}
		
			@Override
			public void remove(Component component) {
				this.arrayList.remove(component);
			}
		
			@Override
			public ArrayList<Component> getChildren() {
				return this.arrayList;
			}
		
			@Override
			public void doSomething() {
				// TODO Auto-generated method stub	
			}
			
		}	
	
//场景类
	public class Client{	
		public static void main(String[] args) {
			Composite root=new Composite();
			root.doSomething();
			Composite branch=new Composite();
			branch.doSomething();
			Leaf leaf1=new Leaf();
			Leaf leaf2=new Leaf();
			root.add(branch);
			branch.add(leaf1);
			branch.add(leaf2);
		}	
		
		public static void display(Composite root) {
			root.doSomething();
			for(Component c:root.getChildren) {
				if(c instanceof Leaf) {
					c.doSomething();
				}else {
					c.doSomething();
					display((Composite)c);
				}
			}
			
		}
	}
	

//被观察者
	public abstract class Subject{
		
		private Vector<Observer> vector=new Vector();
		public void addObserver(Observer observer) {
			this.vector.add(observer);
		}
		public void removeObserver(Observer observer) {
			this.vector.remove(observer);
		}
		public void notifyObserver() {
			for(Observer observer:this.vector)
			observer.update();
		}
	}
	
//具体观察者
	public class ConcreteSubject extends Subject{
		public void doSomething() {
			//做什么事情
			super.notifyObserver();
		}	
}
	
//观察者
	public interface Observer{
		public void update();
	}
	
//具体观察者	
	public class ConcreteObserver implements Observer{
		public void update() {
			System.out.println("收到信息，正在处理");
		}
	}

	
//场景类
	public class Client{	
		public static void main(String[] args) {
			ConcreteSubject concreteSubject =new ConcreteSubject();
			Observer observer1=new Observer();
			Observer observer2=new Observer();
			concreteSubject.add(observer1);
			concreteSubject.add(observer2);
			concreteSubject.doSomething();
		}
	}
	
	
	
//发起人角色
	public class Originator{
		
		private String state="";

		/**
		 * @return the state
		 */
		public String getState() {
			return state;
		}

		/**
		 * @param state the state to set
		 */
		public void setState(String state) {
			this.state = state;
		}
		
		public Memento creatMemento() {
			return new Memento();
		}
		
		public void restoreMemento(Memento memento) {
			this.setState(memento.getState());
		}
		
	}
	
//备忘录角色
	public class Memento{
		private String state="";
		
		public Memento(String state) {
			this.state= state;
		}
		
		/**
		 * @return the state
		 */
		public String getState() {
			return state;
		}

		/**
		 * @param state the state to set
		 */
		public void setState(String state) {
			this.state = state;
		}
	}
	
//备忘录管理员角色
	public class Caretaker{
		private Memento memento;

		/**
		 * @return the memento
		 */
		public Memento getMemento() {
			return memento;
		}

		/**
		 * @param memento the memento to set
		 */
		public void setMemento(Memento memento) {
			this.memento = memento;
		}
		
	}

	//场景类
		public class Client{	
			public static void main(String[] args) {
				Originator originator=new Originator();
				Caretaker caretaker=new Caretaker();
				//创建一个备忘录
				caretaker.setMemento(originator.creatMemento);	
				//恢复一个备忘录
				originator.restoreMemento(caretaker.getMemento);
			}
		}
		

//融合备忘录的发起人角色

		//发起人角色Originator
		public class  Originator implements Cloneable{
			
			private String state="";

			/**
			 * @return the state
			 */
			public String getState() {
				return state;
			}

			/**
			 * @param state the state to set
			 */
			public void setState(String state) {
				this.state = state;
			}
			
			public Memento creatMemento() {
				return this.clone();
			}
			
			public void restoreMemento(Originator originator) {
				this.setState(originator.getState());
			}
			
			public Originator clone() {
				try {
					return (Originator)super.clone();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
	
//备忘录管理员角色
		public class Caretaker{
			private Originator originator;

			/**
			 * @return the originator
			 */
			public Originator getMemento() {
				return originator;
			}

			/**
			 * @param originator the originator to set
			 */
			public void setMemento(Originator originator) {
				this.originator = originator;
			}
			
		}	

//融合备忘录的发起人和管理员角色

		//发起人角色Originator
		public class  Originator implements Cloneable{
			
			private String state="";
			private Originator backup=null;

			/**
			 * @return the state
			 */
			public String getState() {
				return state;
			}

			/**
			 * @param state the state to set
			 */
			public void setState(String state) {
				this.state = state;
			}
			
			public void creatMemento() {
				this.backup=this.clone();
			}
			
			public void restoreMemento() {
				this.setState(this.backup.getState());
			}
			
			public Originator clone() {
				try {
					return (Originator)super.clone();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}

//场景类
		public class Client{	
			public static void main(String[] args) {
				Originator originator=new Originator();
				//创建一个备忘录；
				originator.setState("初始状态");
				//创建一个备忘录备份；
				originator.creatMemento();
				originator.setState("更改后的状态");
				originator.restoreMemento();
			}
		}
		
		
		
//抽象元素
	public abstract class Element{
		public abstract void doSomething();
		public abstract void accept(Visitor vistor);
	}	

	
//具体元素	
	public  class ConcreteElement1 extends Element{
		public  void doSomething() {
			
		};
		public  void accept(Visitor vistor) {
			
		};
	}
	
	public  class ConcreteElement2 extends Element{
		public  void doSomething() {
			
		};
		public  void accept(Visitor vistor) {
			
		};
	}
		
//抽象访问者
	public interface Vistor{
		public abstract void visit(ConcreteElement1 concreteElement1);
		public abstract void visit(ConcreteElement2 concreteElement2);
	}
		
//具体访问者
	public  class ConcreteVistor implements Vistor {
		public void visit(ConcreteElement1 concreteElement1) {
			concreteElement1.doSomething();
		};
		public void visit(ConcreteElement2 concreteElement2) {
			concreteElement2.doSomething();
		};
	}		
		
//具体场景
	public class Client{	
		public static void main(String[] args) {
			Element element = new ConcreteElement1();
			element.accept(new Visitor);
		}
	}
	
	
		
//抽象状态角色
	public abstract class Status{
		protected Context context;
		public void setContext(Context context) {
			this.context=context;
		}
		public abstract void handle1();
		public abstract void handle2();
	}

//具体状态角色
	public class ConcreteStatus1 extends Status{
		public void handle1() {
			//本状态下必须处理的逻辑
		};
		public void handle2() {
			//设置当前的状态为state2
			super.Context.setCurrentStatus(Context.ConcreteStatus1);
			//过渡到state2，由context实现
			super.Context.handle2
		};
	}
	public class ConcreteStatus2 extends Status{
		public void handle1() {
			super.context.setCurrentStatus(Context.concreteStatus2);
			super.context.handle2();	
		};
		public void handle2() {
			//本状态下必须处理的逻辑
		};
	}
		
//具体环境角色
	public class Context{
		//定义状态
		public final static  ConcreteStatus1 =new  ConcreteStatus1();
		public final static  ConcreteStatus2 =new  ConcreteStatus2();
		//当前状态
		private Status currentStatus=null;
		/**
		 * @return the currentStatus
		 */
		public Status getCurrentStatus() {
			return currentStatus;
		}
		/**
		 * @param currentStatus the currentStatus to set
		 */
		public void setCurrentStatus(Status currentStatus) {
			this.currentStatus = currentStatus;
		}
		
		public void handle1(){
			this.currentStatus.handle1();
		}
		public void handle2(){
			this.currentStatus.handle2();
		}
		
	}		
		
//场景类
	public class Client{
		public static void main(String[] avgs) {
			Context context=new Context();
			//定义初始状态
			context.setCurrentStatus(new ConcreteStatus1);
			context.handle1;
			handle1.handle2;		
		}
	}
		
		
//抽象表达式
	public abstract class Expression{
		public abstract Object Interpreter(Context ctx);
	}
		
//终结符表达式
	public class TerminalExpression extends Expression{
		private Object parameter;
		
		/**
		 * @return the parameter
		 */
		public Object getParameter() {
			return parameter;
		}

		/**
		 * @param parameter the parameter to set
		 */
		public void setParameter(Object parameter) {
			this.parameter = parameter;
		}

		public Object Interpreter(Context ctx) {
			return null;
		}
	}
		
//非终结符表达式
	public class NonTerminalExpression1 extends Expression{
		public NonTerminalExpression1(Expression... expressions) {
			// expressions必须是TerminalExpression类
		}
		public Object Interpreter(Context ctx) {
			//调用TerminalExpression的Interpreter的方法继续逻辑运算
			return null;
		}
	}	
	
	public class NonTerminalExpression2 extends Expression{
		public NonTerminalExpression2(Expression... expressions) {
			// expressions必须是TerminalExpression类
		}
		public Object Interpreter(Context ctx) {
			//调用TerminalExpression的Interpreter的方法继续逻辑运算
			return null;
		}
	}
		
//场景类
	public class Client{
		public static void main(String[] args) {
			Context ctx = new Context();
			char[] charArray=ctx.toCharArray();
			//通常定义一个语法容器，来容纳一个具体的表达式
			Stack<Expression> stack=null;
			Expression left=new TerminalExpression();//实际类型是TerminalExpression
			Expression right=new TerminalExpression();//实际类型是TerminalExpression
			Object newLeft=new Object();
			Expression exp=null;//
			for(int i=0;i<charArray.length();i++) {
				if (charArray[i]=="NonTerminalExpression1"){
					left.setParameter(stack.pop);
					right.setParameter(charArray[++i]);
					exp=new NonTerminalExpression1(left,right);
					stack.push(exp.Interpreter(ctx));//把每一步的结果保存下来
				}else if (charArray[i]=="NonTerminalExpression2"){
					left.setParameter(stack.pop);
					right.setParameter(charArray[++i]);
					exp=new NonTerminalExpression2(left,right);
					stack.push(exp.Interpreter(ctx));//把每一步的结果保存下来
				}else if(charArray[i]=="TerminalExpression") {
					stack.push(charArray[i])
				}
			}	
		}
		
	}
		

//抽象享元角色
	public abstract class Flyweight{
		//内部状态
		private String intrinsic;
		//外部状态
		protected final String extrinsic;
		
		public Flyweight(String extrinsic) {
			this.extrinsic=extrinsic;
		}
		//定义业务操作
		public abstract void operate();
		/**
		 * @return the intrinsic
		 */
		public String getIntrinsic() {
			return intrinsic;
		}
		/**
		 * @param intrinsic the intrinsic to set
		 */
		public void setIntrinsic(String intrinsic) {
			this.intrinsic = intrinsic;
		}
		
	}
	
//具体享元角色
	public class ConcreteFlyweight1 extends Flyweight{
		//接收外部状态
		public ConcreteFlyweight1(String extrinsic) {
			super(extrinsic);
		}
		//跟据外部状态进行逻辑处理
		public void operate() {
			//业务逻辑
		}
	}

	public class ConcreteFlyweight2 extends Flyweight{
		//接收外部状态
		public ConcreteFlyweight2(String extrinsic) {
			super(extrinsic);
		}
		//跟据外部状态进行逻辑处理
		public void operate() {
			//业务逻辑
		}
	}

//享元工厂
	public class FlywightFactory{
		//定义一个容器
		private static HashMap<String, Flyweight> pool=new HashMap()<String, Flyweight>;
		//巷元工厂
		public static Flyweight getFlyweight(String extrinsic) {
			Flyweight flyweight=null;
			if(pool.containsKey(extrinsic)) {
				flyweight=pool.get(extrinsic);
			}else {
				flyweight=new Flyweight(extrinsic);
				pool.put(extrinsic, flyweight)
			}
			return flyweight
		}
	}
	
	
//外部状态类
	public class ExtrinsicState{
		private String subject;
		private String location;
		/**
		 * @return the subject
		 */
		public String getSubject() {
			return subject;
		}
		/**
		 * @return the location
		 */
		public String getLocation() {
			return location;
		}
		/**
		 * @param subject the subject to set
		 */
		public void setSubject(String subject) {
			this.subject = subject;
		}
		/**
		 * @param location the location to set
		 */
		public void setLocation(String location) {
			this.location = location;
		}
		
		@Override
		public boolean equals(Object obj) {
		if (obj instanceof ExtrinsicState) {
			ExtrinsicState extrinsicState=(ExtrinsicState)obj;
			return (extrinsicState.getLocation().equals(this.location) && 
					extrinsicState.getSubject()().equals(this.subject));
		}
		return false;
		}		
		@Override
		public int hashCode() {
		// TODO Auto-generated method stub
			return this.location.hashCode()+this.subject.hashCode();
		}
	}
	
	
//创建工厂，使用dom4j解析配置文件+反射
	//返回UserService对象的方法
	public static User getUser() {
		//使用dom4j解析配置文件
		//跟据ID值得到所对应的class属性值
		String classValue ="class属性值";
		//使用反射创建类对象
		Class clazz=Class.forName(classValue);
		User user=clazz.newInstance();
		return user
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		