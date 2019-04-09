import javafx.animation.FillTransition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.Object;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.PathTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.input.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import java.io.FileInputStream;
import javafx.scene.input.KeyEvent;
import javafx.animation.FadeTransition;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.text.*;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.animation.TranslateTransition;


import javafx.beans.binding.BooleanExpression;
import javafx.beans.property.BooleanProperty;

//Victoria Rafaelian
public class RockPaperScissorsv4 extends Application {
  public boolean wasChoiceMade = false;
  public boolean chooserock = false;
  public boolean choosepaper = false;
  public boolean choosescissors = false;
  public boolean compchooserock = false;
  public boolean compchoosepaper = false;
  public boolean compchoosescissors = false;
  public boolean youwin1 = false;
  public boolean youlose1 = false;
  public boolean youtie1 = false;
  public int win = 0;
  public int lose = 0;
  public boolean youwon = false;
  public boolean youlost = false;
  public boolean round1Finished = false;
  public boolean round2Finished = false;
  public boolean round3Finished = false;

  public Text ready = new Text();
  public Text pickOne = new Text();
  public Text tie = new Text();
  public Text ouch = new Text();
  public Text greatChoice1 = new Text();
  public Text win1 = new Text();
  public Text win2 = new Text();
  public Text win3 = new Text();
  public Text lose1 = new Text();
  public Text lose2 = new Text();
  public Text lose3 = new Text();
  public Text nextRound = new Text();
  public Text youLost = new Text();
  public Text youWon = new Text();

  @Override
  public void start(Stage primaryStage) throws FileNotFoundException {
    setUpTexts();

    Image image1 = new Image(new FileInputStream("rock.png"));
    ImageView rock = new ImageView(image1);
    rock.setX(20);
    rock.setY(220);
    rock.setFitHeight(400);
    rock.setFitWidth(200);
    rock.setPreserveRatio(true);
    rock.setOpacity(0.0);

    Image image2 = new Image(new FileInputStream("paper.png"));
    ImageView paper = new ImageView(image2);
    paper.setX(330);
    paper.setY(250);
    paper.setFitHeight(130);
    paper.setFitWidth(130);
    paper.setPreserveRatio(true);
    paper.setOpacity(0.0);

    Image image3 = new Image(new FileInputStream("scissors.png"));
    ImageView scissors = new ImageView(image3);
    scissors.setX(550);
    scissors.setY(270);
    scissors.setFitHeight(400);
    scissors.setFitWidth(200);
    scissors.setPreserveRatio(true);
    scissors.setOpacity(0.0);

    Image image4 = new Image(new FileInputStream("comprock.png"));
    ImageView comprock = new ImageView(image4);
    comprock.setX(300);
    comprock.setY(120);
    comprock.setFitHeight(300);
    comprock.setFitWidth(150);
    comprock.setPreserveRatio(true);
    comprock.setOpacity(0.0);
    comprock.toBack();

    Image image5 = new Image(new FileInputStream("comppaper.png"));
    ImageView comppaper = new ImageView(image5);
    comppaper.setX(310);
    comppaper.setY(100);
    comppaper.setFitHeight(300);
    comppaper.setFitWidth(150);
    comppaper.setPreserveRatio(true);
    comppaper.setOpacity(0.0);
    comppaper.toBack();

    Image image6 = new Image(new FileInputStream("compscissors.png"));
    ImageView compscissors = new ImageView(image6);
    compscissors.setX(315);
    compscissors.setY(120);
    compscissors.setFitHeight(300);
    compscissors.setFitWidth(150);
    compscissors.setPreserveRatio(true);
    compscissors.setOpacity(0.0);
    compscissors.toBack();


    paper.toFront();
    Text go = new Text();
    go.setX(340);
    go.setY(200);
    go.setFill(Color.WHITE);
    go.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    go.setTextAlignment(TextAlignment.JUSTIFY);
    go.setText("GO!");
    go.setOpacity(0.0);

    FadeTransition fadetogo = new FadeTransition(Duration.millis(1000));
    fadetogo.setNode(ready);
    fadetogo.setFromValue(1.0);
    fadetogo.setToValue(0.0);
    fadetogo.setCycleCount(2);
    fadetogo.setAutoReverse(false);
    fadetogo.play();


    fadetogo.setOnFinished(event -> {
      System.out.println("Let's do this!!");
      go.setOpacity(1.0);
      FadeTransition fadetogame = new FadeTransition(Duration.millis(3000));
      fadetogame.setNode(go);
      fadetogame.setFromValue(1.0);
      fadetogame.setToValue(0.0);
      fadetogame.setCycleCount(1);
      fadetogame.setAutoReverse(false);
      fadetogame.play();


      rock.setOpacity(1.0);
      paper.setOpacity(1.0);
      scissors.setOpacity(1.0);
      pickOne.setOpacity(1.0);
    });

    setUpBouncing(rock, paper, scissors);

    System.out.println("Back to the top!");
    compChooseObject();


    if (win == 0 && lose == 0) {
      rock.setOpacity(1.0);
      paper.setOpacity(1.0);
      scissors.setOpacity(1.0);
      pickOne.setOpacity(1.0);
      greatChoice1.setOpacity(0.0);

      EventHandler<MouseEvent> eventHandler1 = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          System.out.println("Rock, eh? Not a bad choice! Lets see what the other players got in mind...");
          rock.setOpacity(1.0);
          paper.setOpacity(0.0);
          scissors.setOpacity(0.0);
          pickOne.setOpacity(0.0);
          wasChoiceMade = true;
          chooserock = true;

          if (compchooserock) {
            System.out.println("Tie!");
            youtie1 = true;
            tie.setOpacity(1.0);
            comprock.setOpacity(1.0);

            FadeTransition compRockFade = new FadeTransition(Duration.millis(2000));
            compRockFade.setNode(comprock);
            compRockFade.setFromValue(1.0);
            compRockFade.setToValue(0.0);
            compRockFade.setCycleCount(1);
            compRockFade.setAutoReverse(false);
            compRockFade.play();

            FadeTransition tieFade = new FadeTransition(Duration.millis(3000));
            tieFade.setNode(tie);
            tieFade.setFromValue(1.0);
            tieFade.setToValue(0.0);
            tieFade.setCycleCount(1);
            tieFade.setAutoReverse(false);
            tieFade.play();

            tieFade.setOnFinished(event -> {
              System.out.println("Game Status: Offline");
              Platform.exit();
            });


          } else if (compchoosescissors) {
            System.out.println("You win one!");
            youwin1 = true;
            win = win + 1;
            greatChoice1.setOpacity(1.0);
            compscissors.setOpacity(1.0);

            FadeTransition compScissorsFade = new FadeTransition(Duration.millis(2000));
            compScissorsFade.setNode(compscissors);
            compScissorsFade.setFromValue(1.0);
            compScissorsFade.setToValue(0.0);
            compScissorsFade.setCycleCount(1);
            compScissorsFade.setAutoReverse(false);
            compScissorsFade.play();


            FadeTransition greatChoiceFade = new FadeTransition(Duration.millis(3000));
            greatChoiceFade.setNode(greatChoice1);
            greatChoiceFade.setFromValue(1.0);
            greatChoiceFade.setToValue(0.0);
            greatChoiceFade.setCycleCount(1);
            greatChoiceFade.setAutoReverse(false);
            greatChoiceFade.play();

            greatChoiceFade.setOnFinished(event -> {
              System.out.println("Round Finished");
              round1Finished = true;
              nextRound.setOpacity(1.0);
            });

          } else if (compchoosepaper) {
            System.out.println("You lose one!");
            youlose1 = true;
            lose = lose + 1;
            System.out.println(lose);
            ouch.setOpacity(1.0);
            comppaper.setOpacity(1.0);

            FadeTransition compPaperFade = new FadeTransition(Duration.millis(2000));
            compPaperFade.setNode(comppaper);
            compPaperFade.setFromValue(1.0);
            compPaperFade.setToValue(0.0);
            compPaperFade.setCycleCount(1);
            compPaperFade.setAutoReverse(false);
            compPaperFade.play();

            FadeTransition ouchFade = new FadeTransition(Duration.millis(3000));
            ouchFade.setNode(ouch);
            ouchFade.setFromValue(1.0);
            ouchFade.setToValue(0.0);
            ouchFade.setCycleCount(1);
            ouchFade.setAutoReverse(false);
            ouchFade.play();

            ouchFade.setOnFinished(event -> {
              System.out.println("Round Finished");
              round1Finished = true;
              nextRound.setOpacity(1.0);
            });

          }

          checkLosses(rock, paper, scissors);
          if (win == 1) {
            System.out.println("won 1");
            win1.setOpacity(1.0);
            win2.setOpacity(0.0);
            win3.setOpacity(0.0);
          }
          if (win == 2) {
            System.out.println("won 2");
            win1.setOpacity(0.0);
            win2.setOpacity(1.0);
            win3.setOpacity(0.0);
          }
          if (win == 3) {
            System.out.println("won 3");
            win1.setOpacity(0.0);
            win2.setOpacity(0.0);
            win3.setOpacity(1.0);
            youwon = true;
            System.out.println(win);
            rock.setOpacity(0.0);
            paper.setOpacity(0.0);
            scissors.setOpacity(0.0);
            greatChoice1.setOpacity(0.0);
            ouch.setOpacity(0.0);
            pickOne.setOpacity(0.0);
            nextRound.setOpacity(0.0);

            youWon.setOpacity(1.0);
            FadeTransition youWinFade = new FadeTransition(Duration.millis(2500));
            youWinFade.setNode(youWon);
            youWinFade.setFromValue(1.0);
            youWinFade.setToValue(0.0);
            youWinFade.setCycleCount(1);
            youWinFade.setAutoReverse(false);
            youWinFade.play();

            youWinFade.setOnFinished(event -> {
              System.out.println("You're done.");
              Platform.exit();
            });
          }
        }

      };

      rock.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler1);
      rock.removeEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler1);

      EventHandler<MouseEvent> eventHandler2 = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          System.out.println("Paper, huh? Awesome! Lets see what the other players got in mind...");
          rock.setOpacity(0.0);
          paper.setOpacity(1.0);
          scissors.setOpacity(0.0);
          pickOne.setOpacity(0.0);
          wasChoiceMade = true;
          choosepaper = true;

          if (compchoosepaper) {
            System.out.println("Tie!");
            youtie1 = true;
            comppaper.setOpacity(1.0);

            FadeTransition compPaperFade = new FadeTransition(Duration.millis(2000));
            compPaperFade.setNode(comppaper);
            compPaperFade.setFromValue(1.0);
            compPaperFade.setToValue(0.0);
            compPaperFade.setCycleCount(1);
            compPaperFade.setAutoReverse(false);
            compPaperFade.play();

            tie.setOpacity(1.0);

            FadeTransition tieFade = new FadeTransition(Duration.millis(3000));
            tieFade.setNode(tie);
            tieFade.setFromValue(1.0);
            tieFade.setToValue(0.0);
            tieFade.setCycleCount(1);
            tieFade.setAutoReverse(false);
            tieFade.play();

            tieFade.setOnFinished(event -> {
              System.out.println("Game Status: Offline");
              Platform.exit();
            });

          } else if (compchooserock) {
            System.out.println("You win one!");
            youwin1 = true;
            win = win + 1;
            System.out.println(win);
            greatChoice1.setOpacity(1.0);
            comprock.setOpacity(1.0);

            FadeTransition compRockFade = new FadeTransition(Duration.millis(2000));
            compRockFade.setNode(comprock);
            compRockFade.setFromValue(1.0);
            compRockFade.setToValue(0.0);
            compRockFade.setCycleCount(1);
            compRockFade.setAutoReverse(false);
            compRockFade.play();

            FadeTransition greatChoiceFade = new FadeTransition(Duration.millis(3000));
            greatChoiceFade.setNode(greatChoice1);
            greatChoiceFade.setFromValue(1.0);
            greatChoiceFade.setToValue(0.0);
            greatChoiceFade.setCycleCount(1);
            greatChoiceFade.setAutoReverse(false);
            greatChoiceFade.play();

            greatChoiceFade.setOnFinished(event -> {
              System.out.println("Round Finished");
              round1Finished = true;
              nextRound.setOpacity(1.0);
            });

          } else if (compchoosescissors) {
            System.out.println("You lose one!");
            youlose1 = true;
            lose = lose + 1;
            System.out.println(lose);
            ouch.setOpacity(1.0);
            compscissors.setOpacity(1.0);

            FadeTransition compScissorsFade = new FadeTransition(Duration.millis(2000));
            compScissorsFade.setNode(compscissors);
            compScissorsFade.setFromValue(1.0);
            compScissorsFade.setToValue(0.0);
            compScissorsFade.setCycleCount(1);
            compScissorsFade.setAutoReverse(false);
            compScissorsFade.play();

            FadeTransition ouchFade = new FadeTransition(Duration.millis(3000));
            ouchFade.setNode(ouch);
            ouchFade.setFromValue(1.0);
            ouchFade.setToValue(0.0);
            ouchFade.setCycleCount(1);
            ouchFade.setAutoReverse(false);
            ouchFade.play();

            ouchFade.setOnFinished(event -> {
              System.out.println("Round Finished");
              round1Finished = true;
              nextRound.setOpacity(1.0);
            });

          }


          checkLosses(rock, paper, scissors);
          if (win == 1) {
            System.out.println("won 1");
            win1.setOpacity(1.0);
            win2.setOpacity(0.0);
            win3.setOpacity(0.0);
          }
          if (win == 2) {
            System.out.println("won 2");
            win1.setOpacity(0.0);
            win2.setOpacity(1.0);
            win3.setOpacity(0.0);
          }
          if (win == 3) {
            System.out.println("won 3");
            win1.setOpacity(0.0);
            win2.setOpacity(0.0);
            win3.setOpacity(1.0);
            youwon = true;
            System.out.println(win);
            rock.setOpacity(0.0);
            paper.setOpacity(0.0);
            scissors.setOpacity(0.0);
            greatChoice1.setOpacity(0.0);
            ouch.setOpacity(0.0);
            pickOne.setOpacity(0.0);
            nextRound.setOpacity(0.0);

            youWon.setOpacity(1.0);
            FadeTransition youWinFade = new FadeTransition(Duration.millis(2500));
            youWinFade.setNode(youWon);
            youWinFade.setFromValue(1.0);
            youWinFade.setToValue(0.0);
            youWinFade.setCycleCount(1);
            youWinFade.setAutoReverse(false);
            youWinFade.play();

            youWinFade.setOnFinished(event -> {
              System.out.println("You're done.");
              Platform.exit();
            });
          }
        }
      };
      paper.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler2);
      paper.removeEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler2);

      EventHandler<MouseEvent> eventHandler3 = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
          System.out.println("Scissors, hm? Great! Lets see what the other players got in mind...");
          rock.setOpacity(0.0);
          paper.setOpacity(0.0);
          scissors.setOpacity(1.0);
          pickOne.setOpacity(0.0);
          wasChoiceMade = true;
          choosescissors = true;

          if (compchoosescissors) {
            System.out.println("Tie!");
            youtie1 = true;
            tie.setOpacity(1.0);
            compscissors.setOpacity(1.0);

            FadeTransition compScissorsFade = new FadeTransition(Duration.millis(2000));
            compScissorsFade.setNode(compscissors);
            compScissorsFade.setFromValue(1.0);
            compScissorsFade.setToValue(0.0);
            compScissorsFade.setCycleCount(1);
            compScissorsFade.setAutoReverse(false);
            compScissorsFade.play();

            FadeTransition tieFade = new FadeTransition(Duration.millis(3000));
            tieFade.setNode(tie);
            tieFade.setFromValue(1.0);
            tieFade.setToValue(0.0);
            tieFade.setCycleCount(1);
            tieFade.setAutoReverse(false);
            tieFade.play();

            tieFade.setOnFinished(event -> {
              System.out.println("Game Status: Offline");
              Platform.exit();
            });

          } else if (compchoosepaper) {
            System.out.println("You win one!");
            youwin1 = true;
            win = win + 1;
            System.out.println(win);
            greatChoice1.setOpacity(1.0);
            comppaper.setOpacity(1.0);

            FadeTransition compPaperFade = new FadeTransition(Duration.millis(2000));
            compPaperFade.setNode(comppaper);
            compPaperFade.setFromValue(1.0);
            compPaperFade.setToValue(0.0);
            compPaperFade.setCycleCount(1);
            compPaperFade.setAutoReverse(false);
            compPaperFade.play();

            FadeTransition greatChoiceFade = new FadeTransition(Duration.millis(3000));
            greatChoiceFade.setNode(greatChoice1);
            greatChoiceFade.setFromValue(1.0);
            greatChoiceFade.setToValue(0.0);
            greatChoiceFade.setCycleCount(1);
            greatChoiceFade.setAutoReverse(false);
            greatChoiceFade.play();

            greatChoiceFade.setOnFinished(event -> {
              System.out.println("Round Finished");
              round1Finished = true;
              nextRound.setOpacity(1.0);
            });

          } else if (compchooserock) {
            System.out.println("You lose one!");
            youlose1 = true;
            lose = lose + 1;
            System.out.println(lose);
            ouch.setOpacity(1.0);
            comprock.setOpacity(1.0);

            FadeTransition compRockFade = new FadeTransition(Duration.millis(2000));
            compRockFade.setNode(comprock);
            compRockFade.setFromValue(1.0);
            compRockFade.setToValue(0.0);
            compRockFade.setCycleCount(1);
            compRockFade.setAutoReverse(false);
            compRockFade.play();

            FadeTransition ouchFade = new FadeTransition(Duration.millis(3000));
            ouchFade.setNode(ouch);
            ouchFade.setFromValue(1.0);
            ouchFade.setToValue(0.0);
            ouchFade.setCycleCount(1);
            ouchFade.setAutoReverse(false);
            ouchFade.play();

            ouchFade.setOnFinished(event -> {
              System.out.println("Round Finished");
              round1Finished = true;
              nextRound.setOpacity(1.0);
            });

          }

          checkLosses(rock, paper, scissors);
          if (win == 1) {
            System.out.println("won 1");
            win1.setOpacity(1.0);
            win2.setOpacity(0.0);
            win3.setOpacity(0.0);
          }
          if (win == 2) {
            System.out.println("won 2");
            win1.setOpacity(0.0);
            win2.setOpacity(1.0);
            win3.setOpacity(0.0);
          }
          if (win == 3) {
            System.out.println("won 3");
            win1.setOpacity(0.0);
            win2.setOpacity(0.0);
            win3.setOpacity(1.0);
            youwon = true;
            System.out.println(win);
            rock.setOpacity(0.0);
            paper.setOpacity(0.0);
            scissors.setOpacity(0.0);
            greatChoice1.setOpacity(0.0);
            ouch.setOpacity(0.0);
            pickOne.setOpacity(0.0);
            nextRound.setOpacity(0.0);


            youWon.setOpacity(1.0);
            FadeTransition youWinFade = new FadeTransition(Duration.millis(2500));
            youWinFade.setNode(youWon);
            youWinFade.setFromValue(1.0);
            youWinFade.setToValue(0.0);
            youWinFade.setCycleCount(1);
            youWinFade.setAutoReverse(false);
            youWinFade.play();

            youWinFade.setOnFinished(event -> {
              System.out.println("You're done.");
              Platform.exit();
            });
          }
        }
      };
      scissors.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler3);
    }



    EventHandler<MouseEvent> nextRoundHandler = new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent e) {

        System.out.println("progress 1");

        rock.setOpacity(1.0);
        paper.setOpacity(1.0);
        scissors.setOpacity(1.0);
        pickOne.setOpacity(1.0);
        nextRound.setOpacity(0.0);
        wasChoiceMade = false;
        chooserock = false;
        choosepaper = false;
        choosescissors = false;
        compchooserock = false;
        compchoosepaper = false;
        compchoosescissors = false;
        youwin1 = false;
        youlose1 = false;
        youtie1 = false;


        compChooseObject();


        EventHandler<MouseEvent> eventHandler4 = new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
            System.out.println("Rock, eh? Not a bad choice! Lets see what the other players got in mind...");
            rock.setOpacity(1.0);
            paper.setOpacity(0.0);
            scissors.setOpacity(0.0);
            pickOne.setOpacity(0.0);
            wasChoiceMade = true;
            chooserock = true;


            if (compchooserock) {
              System.out.println("Tie!");
              youtie1 = true;

              tie.setOpacity(1.0);

              FadeTransition tieFade = new FadeTransition(Duration.millis(3000));
              tieFade.setNode(tie);
              tieFade.setFromValue(1.0);
              tieFade.setToValue(0.0);
              tieFade.setCycleCount(1);
              tieFade.setAutoReverse(false);
              tieFade.play();

              tieFade.setOnFinished(event -> {
                System.out.println("Game Status: Offline");
                Platform.exit();
              });

            } else if (compchoosescissors) {
              System.out.println("You win one!");
              youwin1 = true;
              greatChoice1.setOpacity(1.0);
              System.out.println(win);
            } else if (compchoosepaper) {
              System.out.println("You lose one!");
              youlose1 = true;
              System.out.println(lose);
              ouch.setOpacity(1.0);
            } else {
              System.out.println("Error: computer chose nothing.");
            }

            checkLosses(rock, paper, scissors);
            if (win == 1) {
              System.out.println("won 1");
              win1.setOpacity(1.0);
              win2.setOpacity(0.0);
              win3.setOpacity(0.0);
            }
            if (win == 2) {
              System.out.println("won 2");
              win1.setOpacity(0.0);
              win2.setOpacity(1.0);
              win3.setOpacity(0.0);
            }
            if (win == 3) {
              System.out.println("won 3");
              win1.setOpacity(0.0);
              win2.setOpacity(0.0);
              win3.setOpacity(1.0);
              youwon = true;
              System.out.println(win);
              rock.setOpacity(0.0);
              paper.setOpacity(0.0);
              scissors.setOpacity(0.0);
              greatChoice1.setOpacity(0.0);
              ouch.setOpacity(0.0);
              pickOne.setOpacity(0.0);
              nextRound.setOpacity(0.0);

              youWon.setOpacity(1.0);
              FadeTransition youWinFade = new FadeTransition(Duration.millis(2500));
              youWinFade.setNode(youWon);
              youWinFade.setFromValue(1.0);
              youWinFade.setToValue(0.0);
              youWinFade.setCycleCount(1);
              youWinFade.setAutoReverse(false);
              youWinFade.play();

              youWinFade.setOnFinished(event -> {
                System.out.println("You're done.");
                Platform.exit();
              });
            }

          }

        };
        rock.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler4);


        EventHandler<MouseEvent> eventHandler5 = new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
            System.out.println("Paper, huh? Awesome! Lets see what the other players got in mind...");
            rock.setOpacity(0.0);
            paper.setOpacity(1.0);
            scissors.setOpacity(0.0);
            pickOne.setOpacity(0.0);
            wasChoiceMade = true;
            choosepaper = true;

            if (compchoosepaper) {
              System.out.println("Tie!");
              youtie1 = true;

              tie.setOpacity(1.0);

              FadeTransition tieFade = new FadeTransition(Duration.millis(3000));
              tieFade.setNode(tie);
              tieFade.setFromValue(1.0);
              tieFade.setToValue(0.0);
              tieFade.setCycleCount(1);
              tieFade.setAutoReverse(false);
              tieFade.play();

              tieFade.setOnFinished(event -> {
                System.out.println("Game Status: Offline");
                Platform.exit();
              });

            } else if (compchooserock) {
              System.out.println("You win one!");
              youwin1 = true;
              greatChoice1.setOpacity(1.0);
              System.out.println(win);
            } else if (compchoosescissors) {
              System.out.println("You lose one!");
              youlose1 = true;
              System.out.println(lose);
              ouch.setOpacity(1.0);
            } else {
              System.out.println("Error: computer chose nothing.");
            }


            checkLosses(rock, paper, scissors);
            if (win == 1) {
              System.out.println("won 1");
              win1.setOpacity(1.0);
              win2.setOpacity(0.0);
              win3.setOpacity(0.0);
            }
            if (win == 2) {
              System.out.println("won 2");
              win1.setOpacity(0.0);
              win2.setOpacity(1.0);
              win3.setOpacity(0.0);
            }
            if (win == 3) {
              System.out.println("won 3");
              win1.setOpacity(0.0);
              win2.setOpacity(0.0);
              win3.setOpacity(1.0);
              youwon = true;
              System.out.println(win);
              rock.setOpacity(0.0);
              paper.setOpacity(0.0);
              scissors.setOpacity(0.0);
              greatChoice1.setOpacity(0.0);
              ouch.setOpacity(0.0);
              pickOne.setOpacity(0.0);
              nextRound.setOpacity(0.0);

              youWon.setOpacity(1.0);
              FadeTransition youWinFade = new FadeTransition(Duration.millis(2500));
              youWinFade.setNode(youWon);
              youWinFade.setFromValue(1.0);
              youWinFade.setToValue(0.0);
              youWinFade.setCycleCount(1);
              youWinFade.setAutoReverse(false);
              youWinFade.play();

              youWinFade.setOnFinished(event -> {
                System.out.println("You're done.");
                Platform.exit();
              });
            }

          }
        };
        paper.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler5);

        EventHandler<MouseEvent> eventHandler6 = new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent e) {
            System.out.println("Scissors, hm? Great! Lets see what the other players got in mind...");
            rock.setOpacity(0.0);
            paper.setOpacity(0.0);
            scissors.setOpacity(1.0);
            pickOne.setOpacity(0.0);
            wasChoiceMade = true;
            choosescissors = true;

            if (compchoosescissors) {
              System.out.println("Tie!");
              youtie1 = true;

              tie.setOpacity(1.0);

              FadeTransition tieFade = new FadeTransition(Duration.millis(3000));
              tieFade.setNode(tie);
              tieFade.setFromValue(1.0);
              tieFade.setToValue(0.0);
              tieFade.setCycleCount(1);
              tieFade.setAutoReverse(false);
              tieFade.play();

              tieFade.setOnFinished(event -> {
                System.out.println("Game Status: Offline");
                Platform.exit();
              });

            } else if (compchoosepaper) {
              System.out.println("You win one!");
              youwin1 = true;
              greatChoice1.setOpacity(1.0);
              System.out.println(win);
            } else if (compchooserock) {
              System.out.println("You lose one!");
              youlose1 = true;
              System.out.println(lose);
              ouch.setOpacity(1.0);
            } else {
              System.out.println("Error: computer chose nothing.");
            }
            checkLosses(rock, paper, scissors);

            if (win == 1) {
              System.out.println("won 1");
              win1.setOpacity(1.0);
              win2.setOpacity(0.0);
              win3.setOpacity(0.0);
            }
            if (win == 2) {
              System.out.println("won 2");
              win1.setOpacity(0.0);
              win2.setOpacity(1.0);
              win3.setOpacity(0.0);
            }
            if (win == 3) {
              System.out.println("won 3");
              win1.setOpacity(0.0);
              win2.setOpacity(0.0);
              win3.setOpacity(1.0);
              youwon = true;
              System.out.println(win);
              rock.setOpacity(0.0);
              paper.setOpacity(0.0);
              scissors.setOpacity(0.0);
              greatChoice1.setOpacity(0.0);
              ouch.setOpacity(0.0);
              pickOne.setOpacity(0.0);
              nextRound.setOpacity(0.0);

              youWon.setOpacity(1.0);
              FadeTransition youWinFade = new FadeTransition(Duration.millis(2500));
              youWinFade.setNode(youWon);
              youWinFade.setFromValue(1.0);
              youWinFade.setToValue(0.0);
              youWinFade.setCycleCount(1);
              youWinFade.setAutoReverse(false);
              youWinFade.play();

              youWinFade.setOnFinished(event -> {
                System.out.println("You're done.");
                Platform.exit();
              });
            }

          }
        };
        scissors.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler6);

      }
    };
    nextRound.addEventFilter(MouseEvent.MOUSE_CLICKED, nextRoundHandler);

    //Group, scene, stage, game start
    Group root = new Group(ready, go, rock, paper, scissors, comprock, comppaper, compscissors, pickOne, greatChoice1, tie, lose1, win1, win2, lose2, win3, lose3, nextRound, ouch, youLost, youWon);
    Scene scene = new Scene(root, 800, 400);
    primaryStage.setTitle("Rock Paper Scissors");
    scene.setFill(Color.BLACK);
    primaryStage.setScene(scene);
    primaryStage.show();
  }


  //once countdown method finishes running, display the computer's choice!
  //Then compare computer with player choice, and set timer into play
  public boolean compChooseObject() {
    double randomNumber = Math.random();
    if (randomNumber <= 0.33) {
      System.out.println("Computer got Rock.");
      compchooserock = true;
      return compchooserock;

    } else if (randomNumber >= 0.33 && randomNumber <= 0.66) {
      System.out.println("Computer got Paper.");
      compchoosepaper = true;
      return compchoosepaper;
    } else {
      System.out.println("Computer got Scissors.");
      compchoosescissors = true;
      return compchoosescissors;
    }
  }


  //initial creation of game texts
  public void setUpTexts() {
    System.out.println("setting up");
    ready.setX(280);
    ready.setY(200);
    ready.setFill(Color.WHITE);
    ready.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    ready.setTextAlignment(TextAlignment.JUSTIFY);
    ready.setText("READY?");

    pickOne.setX(250);
    pickOne.setY(100);
    pickOne.setFill(Color.WHITE);
    pickOne.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    pickOne.setTextAlignment(TextAlignment.JUSTIFY);
    pickOne.setText("PICK ONE!");
    pickOne.setOpacity(0.0);

    nextRound.setX(250);
    nextRound.setY(170);
    nextRound.setFill(Color.WHITE);
    nextRound.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    nextRound.setTextAlignment(TextAlignment.JUSTIFY);
    nextRound.setText("Click for Next Round");
    nextRound.setOpacity(0.0);

    lose1.setX(80);
    lose1.setY(200);
    lose1.setFill(Color.RED);
    lose1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
    lose1.setTextAlignment(TextAlignment.JUSTIFY);
    lose1.setText("1");
    lose1.setOpacity(0.0);

    lose2.setX(80);
    lose2.setY(200);
    lose2.setFill(Color.RED);
    lose2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
    lose2.setTextAlignment(TextAlignment.JUSTIFY);
    lose2.setText("2");
    lose2.setOpacity(0.0);

    lose3.setX(80);
    lose3.setY(200);
    lose3.setFill(Color.RED);
    lose3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
    lose3.setTextAlignment(TextAlignment.JUSTIFY);
    lose3.setText("3");
    lose3.setOpacity(0.0);

    win1.setX(650);
    win1.setY(200);
    win1.setFill(Color.GREEN);
    win1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
    win1.setTextAlignment(TextAlignment.JUSTIFY);
    win1.setText("1");
    win1.setOpacity(0.0);

    win2.setX(650);
    win2.setY(200);
    win2.setFill(Color.GREEN);
    win2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
    win2.setTextAlignment(TextAlignment.JUSTIFY);
    win2.setText("2");
    win2.setOpacity(0.0);

    win3.setX(650);
    win3.setY(200);
    win3.setFill(Color.GREEN);
    win3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
    win3.setTextAlignment(TextAlignment.JUSTIFY);
    win3.setText("3");
    win3.setOpacity(0.0);

    greatChoice1.setX(220);
    greatChoice1.setY(100);
    greatChoice1.setFill(Color.WHITE);
    greatChoice1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    greatChoice1.setTextAlignment(TextAlignment.JUSTIFY);
    greatChoice1.setText("Great Choice!");
    greatChoice1.setOpacity(0.0);

    ouch.setX(300);
    ouch.setY(100);
    ouch.setFill(Color.WHITE);
    ouch.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    ouch.setTextAlignment(TextAlignment.JUSTIFY);
    ouch.setText("Ouch!");
    ouch.setOpacity(0.0);

    tie.setX(340);
    tie.setY(100);
    tie.setFill(Color.WHITE);
    tie.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 50));
    tie.setTextAlignment(TextAlignment.JUSTIFY);
    tie.setText("Tie!");
    tie.setOpacity(0.0);

    youLost.setX(200);
    youLost.setY(300);
    youLost.setFill(Color.RED);
    youLost.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
    youLost.setTextAlignment(TextAlignment.JUSTIFY);
    youLost.setText("You lost!");
    youLost.setOpacity(0.0);
    youLost.toBack();

    youWon.setX(200);
    youWon.setY(300);
    youWon.setFill(Color.GREEN);
    youWon.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
    youWon.setTextAlignment(TextAlignment.JUSTIFY);
    youWon.setText("You won!");
    youWon.setOpacity(0.0);
    youWon.toBack();
  }

  public void setUpBouncing(ImageView rock, ImageView paper, ImageView scissors) {
    TranslateTransition rockMoving = new TranslateTransition();
    rockMoving.setDuration(Duration.millis(1000));
    rockMoving.setNode(rock);
    rockMoving.setByY(30);
    rockMoving.setCycleCount(rockMoving.INDEFINITE);
    rockMoving.setAutoReverse(true);
    rockMoving.play();

    TranslateTransition paperMoving = new TranslateTransition();
    paperMoving.setDuration(Duration.millis(1000));
    paperMoving.setNode(paper);
    paperMoving.setByY(30);
    paperMoving.setCycleCount(paperMoving.INDEFINITE);
    paperMoving.setAutoReverse(true);
    paperMoving.play();

    TranslateTransition scissorsMoving = new TranslateTransition();
    scissorsMoving.setDuration(Duration.millis(1000));
    scissorsMoving.setNode(scissors);
    scissorsMoving.setByY(30);
    scissorsMoving.setCycleCount(scissorsMoving.INDEFINITE);
    scissorsMoving.setAutoReverse(true);
    scissorsMoving.play();
  }

  public void checkLosses(ImageView rock, ImageView paper, ImageView scissors) {
    if (lose == 1) {
      System.out.println("lost 1");
      lose1.setOpacity(1.0);
      lose2.setOpacity(0.0);
      lose3.setOpacity(0.0);
    }
    if (lose == 2) {
      System.out.println("lost 2");
      lose1.setOpacity(0.0);
      lose2.setOpacity(1.0);
      lose3.setOpacity(0.0);
    }
    if (lose == 3) {
      System.out.println("lost 3");
      lose1.setOpacity(0.0);
      lose2.setOpacity(0.0);
      lose3.setOpacity(1.0);
      youlost = true;
      System.out.println(lose);
      rock.setOpacity(0.0);
      paper.setOpacity(0.0);
      scissors.setOpacity(0.0);
      greatChoice1.setOpacity(0.0);
      ouch.setOpacity(0.0);
      pickOne.setOpacity(0.0);
      nextRound.setOpacity(0.0);

      youLost.setOpacity(1.0);
      FadeTransition youLostFade = new FadeTransition(Duration.millis(2500));
      youLostFade.setNode(youLost);
      youLostFade.setFromValue(1.0);
      youLostFade.setToValue(0.0);
      youLostFade.setCycleCount(1);
      youLostFade.setAutoReverse(false);
      youLostFade.play();

      youLostFade.setOnFinished(event -> {
        System.out.println("You're done.");
        Platform.exit();
      });
    }
  }
    //other methods (display game end (win and loss/update score??/countdown message (3,2,1 write it down here and call it up there again and again)) message)
    public static void main(String args[]) {
      launch(args);
    }
  }
