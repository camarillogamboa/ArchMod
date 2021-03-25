package arch.math.dimath;

import java.util.function.DoubleSupplier;

public interface DiMathLambdaFactory {

    String ELLIPSE_LAMBDA_STRING = "t{c1:[0],c2:[1],r:[2]}->{c1+r*cos(t),c2+r*sin(t)}";
    String CYCLOID_LAMBDA_STRING = "t{r:[0]}->{r*(t-sin(t)),t*(cos(t)-1)}";
    String HEART_LAMBDA_STRING = "t->{12*sin(t)-4*sin(3*t),13*cos(t)-5*cos(2*t)-2*cos(3*t)-cos(4*t)}";
    String PROPELLER_LAMBDA_STRING = "t{r:[0],c:[1]}->{r*cos(t),r*sin(t),c*t}";
    String SPHERE_LAMBDA_STRING = "(u,v){r:[0]}->{r*cos(u)*cos(v),r*sin(u)*cos(v),r*sin(v)}";
    String ELLIPTICAL_CYLINDER_LAMBDA_STRING = "(u,v){a:[0],b[1]}->{a*cos(u),b*sin(u),v}";
    String BULL_LAMBDA_STRING = "(u,v){a:[0],r:[1]}->{(a+r*cos(u))*cos(v),(a+r*cos(u))*sin(v),r*sin(u)}";

    static DiMathLambda createAEllipseLambda(DoubleSupplier c1, DoubleSupplier c2, DoubleSupplier r) {
        return createASecureDiMathLambda(ELLIPSE_LAMBDA_STRING, c1, c2, r);
    }

    static DiMathLambda createACycloidLambda(DoubleSupplier r) {
        return createASecureDiMathLambda(CYCLOID_LAMBDA_STRING, r);
    }

    static DiMathLambda createAHeartLambda() {
        return createASecureDiMathLambda(HEART_LAMBDA_STRING);
    }

    static DiMathLambda createAPropellerLambda(DoubleSupplier r, DoubleSupplier c) {
        return createASecureDiMathLambda(PROPELLER_LAMBDA_STRING, r, c);
    }

    static DiMathLambda createASphereLambda(DoubleSupplier r) {
        return createASecureDiMathLambda(SPHERE_LAMBDA_STRING, r);
    }

    static DiMathLambda createAEllipticalCylinderLambdaString(DoubleSupplier a, DoubleSupplier b) {
        return createASecureDiMathLambda(ELLIPTICAL_CYLINDER_LAMBDA_STRING, a, b);
    }

    static DiMathLambda createABullLambda(DoubleSupplier a, DoubleSupplier r) {
        return createASecureDiMathLambda(BULL_LAMBDA_STRING, a, r);
    }

    static DiMathLambda createASecureDiMathLambda(String lambdaString, DoubleSupplier... externals) {
        DiMathLambda diMathLambda = null;

        try {
            diMathLambda = new DiMathLambda(lambdaString, externals);
        } catch (DiMathException e) {
            e.printStackTrace(System.out);
        }

        return diMathLambda;
    }

}
