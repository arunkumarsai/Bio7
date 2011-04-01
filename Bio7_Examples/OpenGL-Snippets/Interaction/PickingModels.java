/*
This is a picking example for Bio7 how to select shapes in 3d!
Bio7 offers an easy to use class for picking!
Together with the mouse or key events user interfaces
can be created easily.
*/

import static com.eco.bio7.spatial.SpatialEvents.*;
import java.awt.event.MouseEvent;

/*This Bio7 class is responsible for picking!*/
SpatialPicking pick=new SpatialPicking();
//or: SpatialPicking pick=new SpatialPicking(100,5);
int sel;// Stores the selection id!
float []no_mat = { 0.0f, 0.0f, 0.0f, 1.0f };

public void ecomain(GL gl, GLU glu, GLUT glut) {
	gl.glEnable(GL.GL_COLOR_MATERIAL);
	gl.glColorMaterial(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE);
	gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, no_mat, 0);

	/*If the mouse is pressed the picking starts!*/
	if (isMousePressed()) {

		pick.startPicking(gl, glu, getPressEvent());
		/*Here make the shapes selectable!*/
		gl.glPushName(100);//number to identify the sphere!
		gl.glPushMatrix();
		glut.glutSolidSphere(20, 10, 10);
		gl.glPopMatrix();
		gl.glPopName();

		gl.glPushName(200);//number to identify the sphere!
		gl.glPushMatrix();
		gl.glTranslated(100, 100, 10);
		glut.glutSolidSphere(20, 10, 10);
		gl.glPopMatrix();
		gl.glPopName();

		gl.glPushName(300);//number to identify the sphere!
		gl.glPushMatrix();
		gl.glTranslated(200, 500, 100);
		glut.glutSolidSphere(20, 10, 10);
		gl.glPopMatrix();
		gl.glPopName();
		/*Here is the end of selection*/

		pick.endPicking(gl);
		/*Here we get the selection!*/
		sel = pick.getSelection();

		System.out.println(pick.getSelection());
	}

	/*Here we draw them again ()*/
	gl.glPushMatrix();
	if (sel == 100) {
		/*If you want to adjust coordinates you can fix the rotation with the 
		following method->
		SpatialUtil.setStopMovement(true);
		 */
		gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
	} else {
		gl.glColor4f(0.0f, 0.5f, 0.8f, 1.0f);
	}
	glut.glutSolidSphere(20, 10, 10);
	gl.glPopMatrix();

	gl.glPushMatrix();
	gl.glTranslated(100, 100, 10);
	if (sel == 200) {
		/*If you want to adjust coordinates you can enable the rotation with the 
		following method->
		SpatialUtil.setStopMovement(false);
		 */

		gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
	} else {
		gl.glColor4f(0.0f, 0.5f, 0.8f, 1.0f);
	}
	glut.glutSolidSphere(20, 10, 10);
	gl.glPopMatrix();

	gl.glPushMatrix();
	gl.glTranslated(200, 500, 100);
	if (sel == 300) {
		gl.glColor4f(1.0f, 0.0f, 0.0f, 1.0f);
	} else {
		gl.glColor4f(0.0f, 0.5f, 0.8f, 1.0f);
	}
	glut.glutSolidSphere(20, 10, 10);
	gl.glPopMatrix();

	// Please enter your OpenGL code here
}