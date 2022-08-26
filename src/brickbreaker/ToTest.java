package brickbreaker;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.nio.file.Paths;
import java.util.Random;
import javafx.scene.image.*;
import javafx.scene.media.MediaPlayer;  
import javafx.scene.media.Media;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.*; 
import javafx.stage.Stage;
import javafx.util.Duration;

public class ToTest extends Application {
	//declaring elements of game
	  Stage gameStage; //present in start()
	  //present in initGame()
	  Group root; 
	  Scene gameScene;
	  Rectangle paddle;
	  Circle ball;
	  int ballSpeedX;
	  int ballSpeedY;
	  Group bricks;
	  Timeline gameLoop;
	  Timeline pausebw;
	  int score;
	  Text scoreText;
	  int lives = 2;
	  Button conti;
	  Text liveslost;
	  Text livestext;
	  Group root2 = new Group();
	  Scene lives_lost;
	  Text youLose;
	  Scene game_over;
	  Button game_menu;
	  Pane go;
	  Scene scene;
	  Button start_game;
	  
	  @Override
	public void start(Stage primaryStage) {
		StackPane root = new StackPane();
		Text text = new Text("WELCOME TO BRICK BREAKER");
		text.setTextAlignment(TextAlignment.CENTER);
		Image img = new Image("https://images.wallpaperscraft.com/image/single/wall_brick_yellow_141745_3840x2400.jpg");
		BackgroundImage bImg = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,new BackgroundSize(1.0, 1.0, true, true, false, false));
		Background bGround = new Background(bImg);
		root.setBackground(bGround);
		Text names = new Text("Created by:");
		Text rollno = new Text("Azka, Sarah, Hamza,");
		Text rollno2 = new Text("Mahnoor and Rida :)");
		Button back = new Button("Back to Menu");
		back.setAlignment(Pos.CENTER);
		start_game = new Button ("Start Game");
		Button howto = new Button ("How to Play");
		Button exit = new Button ("Exit Game");
		start_game.setAlignment(Pos.CENTER);
		howto.setAlignment(Pos.CENTER);
		exit.setAlignment(Pos.CENTER);
		//game_menu.setAlignment(Pos.CENTER);
		
		Font font = Font.loadFont("file:resources/fonts/vcr_osd_mono.ttf", 20);
		names.setFont(font);
		rollno.setFont(font);
		rollno2.setFont(font);
		text.setFont(font);
		start_game.setFont(font);
		howto.setFont(font);
		exit.setFont(font);
		
		GridPane pane1 = new GridPane();
        Text txt2 = new Text ("How to play: ");
       
        
        Text txt1=new Text("•When you will bring the mouse over\r\n"
        		+ "the panel,the paddle and the ball\r\n"
        		+ " will start moving.\r\n"
        		+ "•The paddle will move with your mouse\r\n"
        		+ " movement.\r\n"
        		+ "•When the ball will first hit the brick,\r\n "
        		+ "the brick’s color will change from green \r\n"
        		+ " to yellow,\r\n"
        		+ " on the second hit brick’s color will \r\n"
        		+ "change to red,it will break\r\n"
        		+ "•You will get 10 points per hit.\r\n"
        		+ "•You will get two lives in the game,\r\n"
        		+ " then you have to start again.\r\n"
        		+ "");
        txt1.setFont(font);
        txt2.setFont(font);
        pane1.add(txt2, 0, 0);
        pane1.add(txt1, 0, 2);
        back.setFont(font);
        pane1.add(back, 0, 3);
		pane1.setBackground(bGround);
		
		start_game.setMaxSize(300, 300);
		howto.setMaxSize(300, 300);
		exit.setMaxSize(300, 300);
		
		GridPane grid = new GridPane();
		text.setTextAlignment(TextAlignment.CENTER);
		names.setTextAlignment(TextAlignment.CENTER);
		names.setLayoutX(200);
		names.setLayoutY(350);
		rollno.setLayoutX(200);
		rollno.setLayoutY(380);
		rollno.setTextAlignment(TextAlignment.CENTER);
		grid.add(text, 0, 0);
		grid.add(start_game,0,1);
		grid.add(howto, 0, 2);
		grid.add(exit, 0, 3);
		grid.add(names, 0, 5);
		grid.add(rollno, 0, 6);
		grid.add(rollno2, 0, 7);
		grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setAlignment(Pos.CENTER);
        root.getChildren().addAll(grid);
        root.setAlignment(Pos.CENTER);
       
        GridPane pane2 = new GridPane();
        Image img2 = new Image("https://www.dsquintana.blog/content/images/size/w2000/2020/06/syth.jpg");
		BackgroundImage bImg2 = new BackgroundImage(img2,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,new BackgroundSize(1.0, 1.0, true, true, false, false));
		Background bGround2 = new Background(bImg2);
		pane2.setBackground(bGround2);
		
		scene = new Scene(root,600,400);
		Scene second = new Scene(pane1,600,400);
		
		
		EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
            	button();
                gameStage.setScene(second);
            }
  
        };
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
            	button();
                System.exit(0);
            }
  
        };
        EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
            	gameStage = primaryStage;
            	menustop();
				button();
				initGame();
				resumeGame();
				primaryStage.setScene(gameScene);
				gameLoop.play();
				gameStage.show();
            	
            }
  
        };
        back.setOnAction(event);
        start_game.setOnAction(event5);
        howto.setOnAction(event2);
        exit.setOnAction(event3);
        
        gameStage = primaryStage;
        primaryStage.setTitle("BRICKBREAKER");
		primaryStage.setScene(scene);
		menu();
		primaryStage.show();
	    gameStage.setResizable(false);
		
	}
	  
	  public void resumeGame(){
		    ball.setCenterX(gameScene.getWidth() / 2);
		    ball.setCenterY(130);
		    gameScene.setOnMouseMoved(e -> {
		      paddle.setX(e.getX() - paddle.getWidth() / 2);
		      paddle.setOnMouseMoved(e1 ->{
		        gameLoop.play();
		      });
		    });
		  }

		  public void initGame() {
		    root = new Group(); //initializing group for grouping elements
		    gameScene = new Scene(root, 520, 400, Color.BLACK); //scene

		    //paddle that will be controlled to reflect ball
		    paddle = new Rectangle(gameScene.getWidth() / 2 - 40, gameScene.getHeight() - 50, 80, 20); 
		    paddle.setFill(Color.WHITE);

		    //ball that hits bricks
		    ball = new Circle(gameScene.getWidth() / 2, 130, 8, Color.WHITE);
		    ballSpeedX = 0;
		    ballSpeedY = 3;
		    root.getChildren().add(ball);
		    
		    score = 0;
		    scoreText = new Text(10, 390, "Score: " + score);
		    scoreText.setFill(Color.WHITE);
		    livestext = new Text(10, 370,"Lives: " + lives);
		    livestext.setFill(Color.WHITE);
		    liveslost = new Text(100,300,"Lives left = " + lives);
		    //group that contains all the bricks
		    bricks = new Group();
		    //adding three elements to root Group (rectangle, circle, group)
		    root.getChildren().addAll(paddle, bricks, scoreText, livestext);

		    for(int i = 0; i < 8; i++) {
		      for(int j = 0; j < 8; j++) {
		        Rectangle thisBrick = new Rectangle(j * 65, i * 15, 65, 15);
		        thisBrick.setFill(Color.GREEN);
		        thisBrick.setStroke(Color.WHITE);
		        bricks.getChildren().add(thisBrick);
		      }
		    }

		    //timeline animation is a freeform animation
		    gameLoop = new Timeline();
		    //keyframes indicate duration of animation/event and the event itself
		    KeyFrame kf = new KeyFrame(Duration.millis(10), ae -> updateGame());
		    //adding keyframe to animation
		    gameLoop.getKeyFrames().add(kf);
		    //setting animation to loop infinite times
		    gameLoop.setCycleCount(Timeline.INDEFINITE);
		  }
		  
		  
			 
		  public void updateGame() {
		
		      detectCollision();
		      ball.setCenterX(ball.getCenterX() + ballSpeedX);
		      ball.setCenterY(ball.getCenterY() + ballSpeedY);
		  }
		  
		  
		  public void detectCollision() {

		    //BALL-PADDLE COLLISION
		    if(ball.getBoundsInParent().intersects(paddle.getBoundsInParent())){ 
		      //ball moves in different direction for example, diagonally
		      ballSpeedX = randomNumber();
		      //ball's y-direction is reversed i.e., it moves towards bricks 
		      ballSpeedY = ballSpeedY * -1;
		     // duringgame();
		    }
		    
		    //if ball is about to leave the scene width
		    if(ball.getCenterX() <= 0 || ball.getCenterX() >= gameScene.getWidth()) {
		      //reverse ball x-direction
		      ballSpeedX = ballSpeedX * -1;
		     // duringgame();
		    }
		    
		    //if ball is about leave the top of scene 
		    if(ball.getCenterY() <= 0) {
		      //reverse direction i.e., falls down
		      ballSpeedY *= -1;
		     // duringgame();
		    }

		    //for each brick
		    for(int i = 0; i < bricks.getChildren().size(); i++) {
		      //if ball intersects brick
		      if(ball.getBoundsInParent().intersects(bricks.getChildren().get(i).getBoundsInParent())) {
		        ball.setCenterX(ball.getCenterX() - ballSpeedX);
		        ball.setCenterY(ball.getCenterY() - ballSpeedY);
		       // duringgame();
		        //once it hits, it changes direction
		        ballSpeedY *= -1;
		        //call to method
		        changeBrickColor(bricks.getChildren().get(i));
		        
		        //when no bricks remain
		        if(bricks.getChildren().size() == 0) {
		        	win();
		          Text youWin = new Text(gameScene.getWidth() / 2 - 120, gameScene.getHeight() / 2, "You Win!");
		          Font font = Font.loadFont("file:resources/fonts/vcr_osd_mono.ttf", 24);
		          youWin.setFont(font);
		          youWin.setFill(Color.WHITE);
		          game_menu = new Button ("Exit Game");
		          game_menu.setFont(font);
			  		game_menu.setLayoutX(170);
			  		game_menu.setLayoutY(300);
			  		game_menu.setAlignment(Pos.BOTTOM_CENTER);
			  		game_menu.setOnAction(e-> {
			  			System.exit(0);
			  		});
		          root.getChildren().addAll(game_menu,youWin);
		        }
		      }
		    }
		    if(ball.getCenterY() >= gameScene.getHeight()){
		      lives = lives-1;
		      if(lives==1) {
		        livestext.setText("Lives: "+ lives);
		        gameLoop.stop();
		        resumeGame();
		      }
		      else if (lives==0) {
		        livestext.setText("Lives: "+ lives);
		        loss();

		      } 
		    }
		    }
		 EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent e)
            {
                gameStage.setScene(scene);
                button();
                menu();
            }
        };
				public void loss() {
								  Font font = Font.loadFont("file:resources/fonts/vcr_osd_mono.ttf", 24);
								  if(ball.getCenterY() >= gameScene.getHeight()) { 
									  	lose();
								          Image img = new Image ("https://c4.wallpaperflare.com/wallpaper/327/229/161/digital-art-game-over-minimalism-text-wallpaper-preview.jpg");
								  		BackgroundImage bImg = new BackgroundImage(img,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,
								  				BackgroundPosition.CENTER,new BackgroundSize(1.0, 1.0, true, true, false, false));
								  		Background bGround = new Background(bImg);
								  		game_menu = new Button ("Exit Game");
								  		game_menu.setFont(font);
								  		game_menu.setLayoutX(170);
								  		game_menu.setLayoutY(300);
								  		game_menu.setAlignment(Pos.BOTTOM_CENTER);
								  		game_menu.setOnAction(e-> {
								  			System.exit(0);
								  		});
								  		go = new Pane();
								  		go.setBackground(bGround);
								  		go.getChildren().add(game_menu);
								  		game_over = new Scene(go,520,400);
								  		gameStage.setScene(game_over);
								      }
								  
							  }
		  
		  
		  public int randomNumber() {
		    //Random class is used to generate random number
		    Random generator = new Random();
		    //.nextInt(limit) the random no is generated from 0 to the limit
		    //-3 makes sure that the random number can be negative too
		    int randNumber = generator.nextInt(7) - 3;
		    return randNumber;
		  }
		  
		  public void changeBrickColor(Node brick){
		    //as brick is a node (all children in group are nodes)
		    //typecasting is done to change node to shape
		    //to detect its colour as getFill() method is not applicable for nodes

		    //if brick is green, change to yellow
		    if(((Shape) brick).getFill()==Color.GREEN){
		      ((Shape) brick).setFill(Color.YELLOW);
		      score += 10;
		      scoreText.setText("Score: " + score);
		    }

		    //if brick is yellow, change to red
		    else if(((Shape) brick).getFill()==Color.YELLOW){
		      ((Shape) brick).setFill(Color.RED);
		      score += 10;
		      scoreText.setText("Score: " + score);
		    }

		    //if brick is red, remove brick
		    else if(((Shape) brick).getFill()==Color.RED){
		      bricks.getChildren().remove(brick);
		      score += 10;
		      scoreText.setText("Score: " + score);
		    }
		  }
		  
		  MediaPlayer mediaplayer;
			public void progressbar() {
				String s = "pg.mp3";
				Media bar = new Media(Paths.get(s).toUri().toString());
				mediaplayer = new MediaPlayer(bar);
				mediaplayer.play();
			}
			MediaPlayer media = new MediaPlayer(new Media(Paths.get("menu.mp3").toUri().toString())); 
			public void menu() {	
				media.play();
			//	media.loop();
				//start_game.setOnAction(e->{media.stop();});
			}
			public void menustop() {
				media.stop();
			}
			MediaPlayer media2;
			public void button() {
				String s = "button.mp3";
				Media bar = new Media(Paths.get(s).toUri().toString());
				media2 = new MediaPlayer(bar);
				media2.play();
			}
			MediaPlayer media3;
			public void lose() {
				String s = "lose.mp3";
				Media bar = new Media(Paths.get(s).toUri().toString());
				media3 = new MediaPlayer(bar);
				media3.play();
			}
			MediaPlayer media4;
			public void duringgame() {
				String s = "brick.mp3";
				Media bar = new Media(Paths.get(s).toUri().toString());
				media4 = new MediaPlayer(bar);
				media4.play();
			}
			MediaPlayer media5;
			public void win() {
				String s = "win.mp3";
				Media bar = new Media(Paths.get(s).toUri().toString());
				media5 = new MediaPlayer(bar);
				media5.play();
			}
			
			public static void main(String[] args) {
			launch(); 
				 }
		}