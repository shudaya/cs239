public class example2{
       public static void main(String[] args){
       	      new P().run();
       }
}
class P{
	public int x;
    public void f(){
		async(here){ x = 5; }
	}
    public void run(){
		finish{
			async(here){ x = 3;}
			this.f();
		}
		finish{
			this.f();
			async(here){ x = 4;}
		}
	}
}