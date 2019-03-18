package raycast.entity.geometry;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import raycast.entity.DrawableObject;

/**
 *
 * @author baphucnguyen
 */
public class PolyShape implements DrawableObject<PolyShape> {

    private int pointCount;
    private double[][] point;
    private double minX, minY, maxX, maxY, strokeWidth;
    private Color fill;
    private Color stroke;
    private RectangleBounds bounds;

    public PolyShape() {
        strokeWidth = 1;
        fill = null;
        stroke = Color.BLACK;
    }

    public PolyShape randomize(double centerX, double centerY, double size, int minPoints, int maxPoints) {
        
        return this;
    }

    public PolyShape setPoints(double... nums) {

        minX = maxX = nums[0];
        minY = maxY = nums[1];

        //initial points and points count
        pointCount = nums.length / 2;
        point = new double[2][pointCount];

        for (int i = 0, j = 0; i < nums.length; i += 2, j++) {

            updateMinMax(nums[i], nums[i + 1]);

            point[0][j] = nums[i];
            point[1][j] = nums[i + 1];
        }

        bounds = new RectangleBounds(minX, minY, maxX - minX, maxY - minY);

        return this;
    }

    private void updateMinMax(double x, double y) {

        if (x < minX) {
            minX = x;
        } else if (x > maxX) {
            maxX = x;
        }

        if (y < minY) {
            minY = y;
        } else if (y > maxY) {
            maxY = y;
        }
    }

    public int pointCount() {

        return pointCount;
    }

    public double[][] points() {

        return point;
    }

    public double pX(int index) {
        return point[0][index];
    }

    public double pY(int index) {
        return point[1][index];
    }

    public void drawCorners(GraphicsContext gc) {

        gc.setFill(Color.PINK);

        for (int i = 0; i < pointCount; i++) {

            gc.fillText(Integer.toString(i), point[0][i] - 5, point[1][i] - 5);

            gc.fillOval(point[0][i] - 5, point[1][i] - 5, 10, 10);

        }
    }

    public RectangleBounds getBounds() {
        return bounds;
    }

    @Override
    public PolyShape setFill(Color color) {
        this.fill = color;
        return this;
    }

    @Override
    public PolyShape setStroke(Color color) {
        this.stroke = color;
        return this;
    }

    @Override
    public PolyShape setWidth(double width) {
        this.strokeWidth = width;
        return this;
    }

    @Override
    public Color getFill() {

        return fill;
    }

    @Override
    public Color getStroke() {

        return stroke;
    }

    @Override
    public double getWidth() {

        return strokeWidth;
    }

    @Override
    public void draw(GraphicsContext gc) {

        gc.setLineWidth(strokeWidth);

        if (stroke != null) {
            gc.setStroke(stroke);
            gc.strokePolygon(point[0], point[1], pointCount);
        }

        if (fill != null) {
            gc.setFill(fill);
            gc.fillPolygon(point[0], point[1], pointCount);
        }
    }

}
