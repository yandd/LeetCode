package knowledge.baseKnowledge._javaCore.javaHighLevel;

//封装就是将属性私有化，提供公有的方法访问私有属性。
//做法就是：修改属性的可见性来限制对属性的访问，并为每个属性创建一对取值（getter）方法和赋值（setter）方法，用于对这些属性的访问。
//通过封装，可以实现对属性的数据访问限制，同时增加了程序的可维护性。
//由于取值方法和赋值方法隐藏了实现的变更，因此并不会影响读取或修改该属性的类，避免了大规模的修改，程序的可维护性增强。
//有时一个方法需要引用调用它的对象。为此，java定义了this这个关键字。简单地说，
//This是在对象内部指代自身的引用。可以直接引用对象，可以解决实例变量和局部变量之间发生的任何同名的冲突。
//4、  如何实现封装，实现封装的具体方法？
//（1）、修改属性的可见性来限制对属性的访问。
//（2）、为每个属性创建一对赋值方法和取值方法，用于对这些属性的访问。
//（3）、在赋值和取值方法中，加入对属性的存取的限制。
//5、什么是构造方法？构造方法的语法规则？
//         构造方法负责对象成员的初始化工作，为实例变量赋予合适的初始值。
//构造方法的语法规则：方法名与类名相同。没有返回类型。
//使用new关键字实例化对象的过程实际上就是调用构造方法的过程。或者说实例化一个对象实际上就是去调用这个对象的构造方法。
//Xin xin=new Xin();
//在实例化对象的时候，已经实例变量赋予了初始值，完成了对象的初始化工作。
//6、  为什么需要构造方法？
//为属性赋值时，很容易忘记对其中的一项或多项进行赋值。构造方法可以简化对象初始化，为实例变量赋值。
//7、  带参数的构造方法：可以显示地为实例变量赋予初始值。在不同的条件下创建不同的对象，这些对象的实例变量具有不同的值。
//注意：在使用带参数的构造方法实例化对象时，传递的值和构造方法的参数应当在个数、次序和数据类型上相互配备。
//通过调用带参数的构造方法，在创建对象时，一并完成了对象的初始化工作，简化了对象初始化的代码。
//8、  什么是方法重载？
//方法名称相同，参数项不相同。那么认为一个方法是另一个方法的重载方法。
//注意：重载只跟参数有关，与返回类型无关。方法名和参数相同而返回类型不相同，不能说是重载。
//典型的方法重载：System.out.println();  Sysstem.out代表了一个java.io.PrintSteam对象，具有多个println(打印)方法，该方法可以接收不同类型的数据作为参数根据类型不同，
//调用不同的打印方法。
//在java.lang包中的Math类中的max方法。
//Public static int max(int a,intb);
//Public static int max(long a,long b);
//Public static int max(float a,float b);
//Public static int max(double a,double b);
//在调用方法之前，java虚拟机先判断给定的类型，然后决定到底调用执行那个max()方法。
//9、  什么是构造方法重载？
//构造方法重载是方法重载的一个典型的特例。参数列表不同。
//可以通过重载构造方法来表达对象的各种多种初始化行为。也就是说在通过new语句创建一个对象时，可以实现在不同的条件下，让不同的对象具有不同的初始化行为。
//Private String name;
//Private String sex;
//Public Xin(String name){
// this.name=name;
//}
//Public Xin(String name,String sex){
//           this.name=name;
//           this.sex=sex;
//}
//良好的封装减少耦合
//类内部的结构可以自由修改（无须修改客户代码）
//可以对成员进行精确控制（年龄范围，性别控制等）
//隐藏信息，实现细节（对象的属性私有化）
public class JavaPackage {
    private String musicName;
    private String musicId;
    private String musicUrl;

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = musicId;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }
}
