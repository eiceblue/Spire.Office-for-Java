import com.spire.presentation.*;
import com.spire.presentation.collections.CommonBehaviorCollection;
import com.spire.presentation.drawing.animation.*;

import java.awt.*;
import java.awt.geom.Point2D;

public class addCustomPathAnimation {
    public static void main(String[] args) throws Exception {
        //Create a PowerPoint Document
        Presentation ppt = new Presentation();

        //Add shape
        IAutoShape shape = ppt.getSlides().get(0).getShapes().appendShape(ShapeType.RECTANGLE, new Rectangle(0, 0, 200, 200));

        //Add animation
        AnimationEffect effect = ppt.getSlides().get(0).getTimeline().getMainSequence().addEffect(shape, AnimationEffectType.PATH_USER);
        CommonBehaviorCollection common = effect.getCommonBehaviorCollection();
        AnimationMotion motion = (AnimationMotion) common.get(0);
        motion.setOrigin(AnimationMotionOrigin.LAYOUT);
        motion.setPathEditMode(AnimationMotionPathEditMode.RELATIVE);

        //add MotionPath
        MotionPath motionPath = new MotionPath();
        motionPath.addPathPoints(MotionCommandPathType.MOVE_TO, new Point2D.Float[]{new Point2D.Float(0, 0)}, MotionPathPointsType.CURVE_AUTO, true);
        motionPath.addPathPoints(MotionCommandPathType.LINE_TO, new Point2D.Float[]{new Point2D.Float(0.1f, 0.1f)}, MotionPathPointsType.CURVE_AUTO, true);
        motionPath.addPathPoints(MotionCommandPathType.LINE_TO, new Point2D.Float[]{new Point2D.Float(-0.1f, 0.2f)}, MotionPathPointsType.CURVE_AUTO, true);
        motionPath.addPathPoints(MotionCommandPathType.END, new Point2D.Float[]{}, MotionPathPointsType.CURVE_AUTO, true);
        motion.setPath(motionPath);

        //Save the Document
        String outputFile = "output/addCustomPathAnimation_out.pptx";
        ppt.saveToFile(outputFile, FileFormat.PPTX_2013);
        ppt.dispose();

    }
}
