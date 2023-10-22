public class Triangle {
    private Point vertexA;
    private Point vertexB;
    private Point vertexC;
    private double[] sides = new double[3];
    private TYPE type;
    private double perimeter;

    public Triangle(Point vA, Point vB, Point vC) {
        this.vertexA = vA;
        this.vertexB = vB;
        this.vertexC = vC;

        setType();
        setPerimeter();
    }

    private double calculateSide(Point pointA, Point pointB) {
        double xA = pointA.getX();
        double yA = pointA.getY();

        double xB = pointB.getX();
        double yB = pointB.getY();

        return Math.sqrt(Math.pow((xA - xB), 2) + Math.pow(yA - yB, 2));
    }

    private TYPE findType() {
        sides[0] = calculateSide(vertexA, vertexB);
        sides[1] = calculateSide(vertexB, vertexC);
        sides[2] = calculateSide(vertexC, vertexA);

        if (sides[0] == sides[1] && sides[1] == sides[2]) {
            return TYPE.EQUILATERAL;
        } else if ((sides[0] == sides[1]) || (sides[1] == sides[2]) ||
                (sides[2] == sides[0])) {
            return TYPE.ISOCELES;
        } else {
            return TYPE.UNKNOWN;
        }
    }

    public TYPE getType() {
        return this.type;
    }

    private void setType() {
        TYPE type = findType();
        this.type = type;
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    private void setPerimeter() {
        this.perimeter = sides[0] + sides[1] + sides[2];
    }

    @Override
    public String toString() {
        return "Triangle <" + this.vertexA + ", " + this.vertexB + ", " + this.vertexC + ">";
    }

    public boolean checkIfPointInsideTriangle(Point point) {
        double distancePtToA = calculateSide(point, vertexA);
        double distancePtToB = calculateSide(point, vertexB);
        double distancePtToC = calculateSide(point, vertexC);

        if (distancePtToA > sides[0] || distancePtToA > sides[1] || distancePtToA > sides[2]) return false;
        if (distancePtToB > sides[0] || distancePtToB > sides[1] || distancePtToB > sides[2]) return false;
        if (distancePtToC > sides[0] || distancePtToC > sides[1] || distancePtToC > sides[2]) return false;

        return true;
    }
}
