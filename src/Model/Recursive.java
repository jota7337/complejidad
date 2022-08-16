package Model;

public class Recursive {
	public int counter=0;
	
	public Recursive() {
		recursivo(10);
		System.out.println(counter);
	}
	
	public void recursivo(double n){
        if(n <= 0.0){
            return;
        }
        counter += 1 ;
        recursivo(n-((n/2)+(n/n)/2));
    }

}
