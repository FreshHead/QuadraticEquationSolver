/**
 * Created by san on 9/22/15.
 */
public class Equation {
    double x1, x2;
    boolean haveSolution = true;

    public Equation(int a, int b, int c) {
        double discriminant = Math.pow(b, 2)-4*a*c;
        if(discriminant>0){
            double sqrtDiscriminant = Math.sqrt(discriminant);
            x1=(-b-sqrtDiscriminant)/2*a;
            x2=(-b+sqrtDiscriminant)/2*a;
        } else if (discriminant == 0){
            x1=x2=-b/2*a;
        } else {
            haveSolution = false;
        }
    }
    public Double getX1(){
        return x1;
    }
    public double getX2(){
        return x2;
    }
}
