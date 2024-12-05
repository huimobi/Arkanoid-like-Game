package project.com;


import project.com.Model.Position;
import project.com.Viewer.PNGDraw;
import project.com.Viewer.WriteText;
import project.com.gui.GUI;

import java.io.IOException;




public class DrawLevel {
    private final GUI gui;

    DrawLevel(GUI gui) throws IOException {
        this.gui=gui;
        draw_level();
    }
    public void draw_level() throws IOException {
        gui.clear();

        //draw corners
        PNGDraw left_corner = new PNGDraw("Elements/Wall/left_corner.png");
        PNGDraw right_corner = new PNGDraw("Elements/Wall/right_corner.png");
        left_corner.drawImage(gui,new Position(0, 0));
        right_corner.drawImage(gui,new Position(7 + 15 * 11, 0));

        //draw side walls
        PNGDraw right_wall = new PNGDraw("Elements/Wall/right_wall.png");
        PNGDraw left_wall = new PNGDraw("Elements/Wall/left_wall.png");
        Position side_walls = new Position(0, 7);
        for (int i = 0; i < 11; i++) {
            left_wall.drawImage(gui,side_walls);
            right_wall.drawImage(gui,new Position(side_walls.getX() + (11 * 15) + 7, side_walls.getY()));
            side_walls.setY(side_walls.getY() + 13);
        }

        //draw ball
        PNGDraw ball = new PNGDraw("Elements/Ball/ball.png");
        ball.drawImage(gui,new Position(80, 90));

        //draw paddle
        PNGDraw paddle = new PNGDraw("Elements/Paddle/paddle.png");
        paddle.drawImage(gui,new Position(60, 130));

        //draw all blocks and the top wall
       int blockSelector=1;
        PNGDraw top_wall = new PNGDraw("Elements/Wall/top_wall.png");
        Position block_p = new Position(7, 0);
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i <= 10; i++) {
                if (j == 0) {
                    top_wall.drawImage(gui,block_p);
                    block_p.setX(block_p.getX() + 15);
                    continue;
                }else if(j==1){
                    PNGDraw brick = new PNGDraw("Elements/Block/unbreackable_block.png");
                    brick.drawImage(gui,block_p);
                    block_p.setX(block_p.getX() + 15);
                    continue;
                }
                if(blockSelector>4) blockSelector-=4;
                PNGDraw brick = new PNGDraw("Elements/Block/block"+String.valueOf(blockSelector)+".png");
                brick.drawImage(gui,block_p);
                block_p.setX(block_p.getX() + 15);
                blockSelector++;
            }
            block_p.setY(block_p.getY() + 8);
            block_p.setX(7);
        }


        //draw side menu
        PNGDraw side_menu=new PNGDraw("Info_Panel/texture.png");
        Position texture=new Position(180,0);
        while(texture.getY()< gui.getHeight()){
            while(texture.getX()<gui.getWidth()){
                side_menu.drawImage(gui,texture);
                texture.setX(texture.getX()+12);
            }
            texture.setX(180);
            texture.setY(texture.getY()+12);
        }

        //Score string display
        WriteText scoreString=new WriteText(gui,"Score");
        Position stringScorePosition= new Position(((gui.getWidth()-(scoreString.getLength()*7)+180)/2),(gui.getHeight()-7)/4);
        scoreString.drawText(gui,stringScorePosition);
        scoreString.setForegroundColor(gui, "#00ff00");

        //score number display
        WriteText scoreNumber=new WriteText(gui,"0000000");
        Position numberScorePosition= new Position((gui.getWidth()-(scoreNumber.getLength()*7)+180)/2,stringScorePosition.getY()+14);
        scoreNumber.drawText(gui,numberScorePosition);

        //Lives display
        PNGDraw lives= new PNGDraw("Info_Panel/lives.png");
        Position livesPos= new Position(gui.getWidth()-3*14-3,3);
        for(int i=0;i<3;i++){
            lives.drawImage(gui,livesPos);
            livesPos.setX(livesPos.getX()+14);
        }
        //Round display
        WriteText round= new WriteText(gui,"round");
        WriteText round_number= new WriteText(gui,"1");
        Position round_string= new Position(gui.getWidth()-5*7-3,gui.getHeight()-14);
        round.drawText(gui,round_string);
        round.setForegroundColor(gui,"#ff0000");
        round_number.drawText(gui,new Position(gui.getWidth()-7,round_string.getY()+7));

        //Highscore string display
        WriteText Highscore= new WriteText(gui,"highscore");
        Highscore.drawText(gui,new Position((((gui.getWidth()-(Highscore.getLength()*7)+180)/2)),gui.getHeight()/2));
        Highscore.setForegroundColor(gui,"#00ff00");

        //highscore value display
        WriteText Highscore_value=new WriteText(gui,"9999999");
        Highscore_value.drawText(gui,new Position((((gui.getWidth()-(Highscore_value.getLength()*7)+180)/2)),gui.getHeight()/2+14));

        gui.refresh();
    }
}