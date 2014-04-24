package calculnumeric5;
import static java.lang.Math.*;
import java.math.BigDecimal;

/**
 * Definite Integrals
 * @author Gabriel Budau
 */
public class Integral {
    double a;
    double b;

    double delta_x;
    
    public Integral(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    protected double f(double x){
        return sin(x);
    }
    
    protected double f1(double x){
        return (pow(x, 7) * sqrt(1 - x*x))/(pow(2-x, 13/2));
        
    }

    public double getDelta_x(int n) {
        return (b-a)/n;
    }
    
    /**
     * 
     * @param I Integral to aproximate
     * @param n precision parameter
     * @return f area
     */
    public static double rectangle_met(Integral I, int n){
        double sum = 0.0;
        
        double delta = I.getDelta_x(n);
        for(double xi= I.a; xi < I.b ; xi += delta){
            sum += (I.f((xi + xi + delta)/2));
        }
        return sum*delta;
    }
    
    /**
     * 
     * @param I Integral to aproximate
     * @param n precision parameter
     * @return f area
     */
    public static double trapezoid_met(Integral I, int n){
        double sum = 0.0;
        
        double delta = I.getDelta_x(n);
        for(double xi= I.a; xi < I.b ; xi += delta){
            sum += (I.f(xi) + I.f(xi + delta));
        }
        return sum*((I.b -I.a)/(2*n));
    }
    
    /**
     * 
     * @param I Integral to aproximate
     * @param n precision parameter
     * @return f area
     */
    public static double simpson_met(Integral I, int n){
        double sum = 0.0;
        
        double delta = I.getDelta_x(n);
        for(double xi= I.a; xi < I.b ; xi += delta){
            sum += (I.f(xi) + 4*(I.f((xi + xi + delta)/2)) + I.f(xi + delta));
        }
        return sum * ((I.b-I.a)/(6*n));
    }
    
    /**
     * 
     * @param I Integral to aproximate
     * @param n precision parameter
     * @return f area
     */
    public static double newton_met(Integral I, int n){
        double sum = 0.0;
        
        double delta = I.getDelta_x(n);
        
        for(double xi= I.a; xi < I.b ; xi += delta){
            sum += 
                    I.f(xi + delta) + 
                    3*(I.f((xi + 2*(xi + delta))/3)) + 
                    3*(I.f((2*xi + (xi + delta))/3)) + 
                    I.f(xi);
        }
        return sum * ((I.b-I.a)/(8*n));
    }
    
}
