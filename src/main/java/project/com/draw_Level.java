package project.com;

import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

import static project.com.Arkanoid.height;
import static project.com.Arkanoid.width;


public class draw_Level {
    public void draw_level(Screen screen) throws IOException {
        screen.clear();

        //draw corners
        PNG_draw left_corner = new PNG_draw("Elements/Wall/left_corner.png");
        PNG_draw right_corner = new PNG_draw("Elements/Wall/right_corner.png");
        left_corner.drawImage(new Position(0, 0));
        right_corner.drawImage(new Position(7 + 15 * 11, 0));

        //draw side walls
        PNG_draw right_wall = new PNG_draw("Elements/Wall/right_wall.png");
        PNG_draw left_wall = new PNG_draw("Elements/Wall/left_wall.png");
        Position side_walls = new Position(0, 7);
        for (int i = 0; i < 11; i++) {
            left_wall.drawImage(side_walls);
            right_wall.drawImage(new Position(side_walls.getX() + (11 * 15) + 7, side_walls.getY()));
            side_walls.setY(side_walls.getY() + 13);
        }

        //draw ball
        PNG_draw ball = new PNG_draw("Elements/Ball/ball.png");
        ball.drawImage(new Position(80, 90));

        //draw paddle
        PNG_draw paddle = new PNG_draw("Elements/Paddle/paddle.png");
        paddle.drawImage(new Position(60, 130));

        //draw all blocks and the top wall
       int blockSelector=1;
        PNG_draw top_wall = new PNG_draw("Elements/Wall/top_wall.png");
        Position block_p = new Position(7, 0);
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i <= 10; i++) {
                if (j == 0) {
                    top_wall.drawImage(block_p);
                    block_p.setX(block_p.getX() + 15);
                    continue;
                }else if(j==1){
                    PNG_draw brick = new PNG_draw("Elements/Block/unbreackable_block.png");
                    brick.drawImage(block_p);
                    block_p.setX(block_p.getX() + 15);
                    continue;
                }
                if(blockSelector>4) blockSelector-=4;
                PNG_draw brick = new PNG_draw("Elements/Block/block"+String.valueOf(blockSelector)+".png");
                brick.drawImage(block_p);
                block_p.setX(block_p.getX() + 15);
                blockSelector++;
            }
            block_p.setY(block_p.getY() + 8);
            block_p.setX(7);
        }


        //draw side menu
        PNG_draw side_menu=new PNG_draw("Info_Panel/texture.png");
        Position texture=new Position(180,0);
        while(texture.getY()<height){
            while(texture.getX()<width){
                side_menu.drawImage(texture);
                texture.setX(texture.getX()+12);
            }
            texture.setX(180);
            texture.setY(texture.getY()+12);
        }

        //Score string display
        WriteText scoreString=new WriteText("Score");
        Position stringScorePosition= new Position(((width-(scoreString.getLenght()*7)+180)/2),(height-7)/4);
        scoreString.drawText(stringScorePosition);
        scoreString.setForegroundColor("#00ff00");

        //score number display
        WriteText scoreNumber=new WriteText("0000000");
        Position numberScorePosition= new Position((width-(scoreNumber.getLenght()*7)+180)/2,stringScorePosition.getY()+14);
        scoreNumber.drawText(numberScorePosition);

        //Lives display
        PNG_draw lives= new PNG_draw("Info_Panel/lives.png");
        Position livesPos= new Position(width-3*14-3,3);
        for(int i=0;i<3;i++){
            lives.drawImage(livesPos);
            livesPos.setX(livesPos.getX()+14);
        }

        screen.refresh();
    }
}