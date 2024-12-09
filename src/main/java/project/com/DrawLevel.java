package project.com;


import project.com.Model.Position;
import project.com.Viewer.PNGReader;
import project.com.Viewer.ViewerProvider;
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


        //draw background
        PNGReader gameBackground= new PNGReader("Game/background");
        gameBackground.draw(gui,new Position(0,0));

        //draw ball
        PNGReader ball = new PNGReader("Elements/Ball/ball");
        ball.draw(gui,new Position(80, 90));

        //draw paddle
        PNGReader paddle = new PNGReader("Elements/Paddle/paddle");
        paddle.draw(gui,new Position(60, 130));

        //draw all blocks and the top wall
       int blockSelector=1;
        Position block_p = new Position(7, 7);
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i <= 10; i++) {
                if(j==0){
                    PNGReader brick = new PNGReader("Elements/Brick/unbreakableBrick");
                    brick.draw(gui,block_p);
                    block_p.setX(block_p.getX() + 15);
                    continue;
                }
                if(blockSelector>4) blockSelector-=4;
                PNGReader brick = new PNGReader("Elements/Brick/brick" +String.valueOf(blockSelector));
                brick.draw(gui,block_p);
                block_p.setX(block_p.getX() + 15);
                blockSelector++;
            }
            block_p.setY(block_p.getY() + 8);
            block_p.setX(7);
        }


        //Score string display
        WriteText scoreString=new WriteText("Score");
        Position stringScorePosition= new Position(((gui.getWidth()-(scoreString.getLength()*7)+180)/2),(gui.getHeight()-7)/4);
        scoreString.drawText(gui,stringScorePosition);
        scoreString.setForegroundColor(gui, "#00ff00");

        //score number display
        WriteText scoreNumber=new WriteText("0000000");
        Position numberScorePosition= new Position((gui.getWidth()-(scoreNumber.getLength()*7)+180)/2,stringScorePosition.getY()+14);
        scoreNumber.drawText(gui,numberScorePosition);

        //Lives display
        PNGReader lives= new PNGReader("Game/lives");
        Position livesPos= new Position(gui.getWidth()-3*14-3,3);
        for(int i=0;i<3;i++){
            lives.draw(gui,livesPos);
            livesPos.setX(livesPos.getX()+14);
        }
        //Round display
        WriteText round= new WriteText("round");
        WriteText round_number= new WriteText("1");
        Position round_string= new Position(gui.getWidth()-5*7-3,gui.getHeight()-14);
        round.drawText(gui,round_string);
        round.setForegroundColor(gui,"#ff0000");
        round_number.drawText(gui,new Position(gui.getWidth()-7,round_string.getY()+7));

        //Highscore string display
        WriteText Highscore= new WriteText("highscore");
        Highscore.drawText(gui,new Position((((gui.getWidth()-(Highscore.getLength()*7)+180)/2)),gui.getHeight()/2));
        Highscore.setForegroundColor(gui,"#00ff00");

        //highscore value display
        WriteText Highscore_value=new WriteText("9999999");
        Highscore_value.drawText(gui,new Position((((gui.getWidth()-(Highscore_value.getLength()*7)+180)/2)),gui.getHeight()/2+14));

        gui.refresh();
    }
}