/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AsianBlackJack;

import java.util.Optional;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author hieud
 */
public class Main extends Application {

    Label playAmount = new Label();
    Button newRound = new Button("New Round");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        launch(args);
        
//        game.intro(System.in);
//        game.setMoneyAmount(System.in);
//        while (player.getAmount() > 0) {
//            game.bet(System.in);
//            game.deal();
//            game.hit(System.in);
//            game.declareWinner(player.getBet());
//            game.reset(System.in);
//        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        

//      create new player and dealer
        Player player = new Player();
        Dealer dealer = new Dealer();

//      create new game
        Game game = new Game(player, dealer);

        Label header = new Label("Welcome to Xi Dach!!!");
        HBox hbox = new HBox();
        Button start = new Button("Start Game");
        Button rules = new Button("Read Rules");
        hbox.getChildren().addAll(start, rules);
        VBox vbox = new VBox();
        Label rulesContent = new Label();
        vbox.getChildren().addAll(header, hbox, rulesContent);
        vbox.setAlignment(Pos.TOP_CENTER);
        hbox.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();

        root.setCenter(vbox);
        root.setAlignment(header, Pos.TOP_CENTER);
        root.setPrefSize(600, 400);
        Scene scene = new Scene(root);
//        scene.getStylesheets().add("fxmlgame.css");
        stage.setScene(scene);
        stage.setTitle("Xi Dach");
        stage.show();

        Label header2 = new Label("Enter money amount:");
        VBox vbox2 = new VBox();
        TextField amount = new TextField();
        amount.setMaxWidth(100);
        Button save = new Button("Save");
        HBox hbox2 = new HBox();
        hbox2.getChildren().addAll(amount, save);
        vbox2.getChildren().addAll(header2, hbox2);
        vbox2.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        BorderPane root2 = new BorderPane();
        root2.setTop(vbox2);
        root2.setPrefSize(600, 400);
        Alert alert = new Alert(Alert.AlertType.NONE);

        rules.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                rulesContent.setText("1. Number cards have values same as their numbe. IE: a TWO has value of 2. \n"
                        + "2. Face cards (JACK, QUEEN, KING) have values of 10. \n"
                        + "3. ACE can have value of either 1 or 10 or 11. \n"
                        + "4. A hand can have maximum five cards. \n"
                        + "5. If one's hand is less than 16 or higher than 21(busted), that hand lose. \n"
                        + "6. In order to win, one's hand total value must be higher than other's and still satisfy the above condition. \n"
                        + "7. If you are busted, your hand is not automatically shown. You have to wait after dealer finish their turn. \n"
                        + "8. BlackJack (Double Ace) beats everything else and bet amount is doubled!!! \n"
                        + "9. Lucky Five (a hand of 5 cards with total value <= 21, can be smaller than 16) only loses to BlackJack. \n"
                        + " Beside BlackJack it beats everything else and bet amount is doubled!!! \n"
                        + "10. After dealer finish their turn, all hands will be shown. Winner takes bet money. Loser loses bet money. \n");
            }
        });

        start.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Scene scene = new Scene(root2);
                stage.setScene(scene);
                stage.setTitle("Xi Dach");
                stage.show();
            }
        });

        BorderPane root3 = new BorderPane();
        Label dealerCard = new Label("Dealer's Hand:");
        Label playerCard = new Label("player's Hand:");

        Button hit = new Button("Hit");
        Button stand = new Button("Stand");
        Label playerBet = new Label(" Your bet: ");
        TextField betAmount = new TextField();
        Button bet = new Button("Bet!");
        HBox hbox3 = new HBox();

        newRound.setDisable(true);
        Button quit = new Button("Quit");
        Label blank = new Label();
        blank.setPrefWidth(50);
        hbox3.setAlignment(Pos.CENTER);
        hbox3.getChildren().addAll(hit, stand, playerBet, betAmount, bet, playAmount, blank, newRound, quit);
        HBox hbox5 = new HBox();
        hbox5.getChildren().add(hbox3);
        root3.setPrefSize(700, 400);

        ImageView dCard1 = new ImageView();
        ImageView dCard2 = new ImageView();
        ImageView dCard3 = new ImageView();
        ImageView dCard4 = new ImageView();
        ImageView dCard5 = new ImageView();
        ImageView pCard1 = new ImageView();
        ImageView pCard2 = new ImageView();
        ImageView pCard3 = new ImageView();
        ImageView pCard4 = new ImageView();
        ImageView pCard5 = new ImageView();
        HBox pHand = new HBox();
        HBox dHand = new HBox();

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    player.setAmount(Double.parseDouble(amount.getText()));
                    playAmount.setText(" You have: $" + Double.toString(player.getAmount()));
                    root3.setBottom(hbox3);
                    hit.setDisable(true);
                    stand.setDisable(true);
                    game.deal();

                    dCard1.setFitHeight(211.2);
                    dCard1.setFitWidth(138.2);
                    dCard2.setFitHeight(211.2);
                    dCard2.setFitWidth(138.2);
                    dCard3.setFitHeight(211.2);
                    dCard3.setFitWidth(138.2);
                    dCard4.setFitHeight(211.2);
                    dCard4.setFitWidth(138.2);
                    dCard5.setFitHeight(211.2);
                    dCard5.setFitWidth(138.2);

                    pCard1.setFitHeight(211.2);
                    pCard1.setFitWidth(138.2);
                    pCard2.setFitHeight(211.2);
                    pCard2.setFitWidth(138.2);
                    pCard3.setFitHeight(211.2);
                    pCard3.setFitWidth(138.2);
                    pCard4.setFitHeight(211.2);
                    pCard4.setFitWidth(138.2);
                    pCard5.setFitHeight(211.2);
                    pCard5.setFitWidth(138.2);

                    dHand.getChildren().addAll(dCard1, dCard2);
                    pHand.getChildren().addAll(pCard1, pCard2);
                    VBox table = new VBox();
                    table.getChildren().addAll(dealerCard, dHand, playerCard, pHand);
                    root3.setCenter(table);
                    Scene scene = new Scene(root3);
                    stage.setScene(scene);
                    stage.setTitle("Xi Dach");
                    stage.show();

                } catch (IllegalArgumentException e) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Data Entry Error");
                    alert.setHeaderText("Invalid Value Entered");
                    alert.setContentText("Amount must be its correct type");
                    alert.show();
                }
            }
        });

        bet.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                player.setBet(Double.parseDouble(betAmount.getText()));
                if (player.getBet() > player.getAmount()) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Data Entry Error");
                    alert.setHeaderText("Invalid Value Entered");
                    alert.setContentText("You don't have enough money!!!");
                    alert.show();
                }
                if (player.getBet() <= 0) {
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setTitle("Data Entry Error");
                    alert.setHeaderText("Invalid Value Entered");
                    alert.setContentText("You must bet more than 0!!!");
                    alert.show();
                } 
                if (player.getBet()>0 && player.getBet()<=player.getAmount()){
                    try {
                        player.removeAmount(player.getBet());
                        playAmount.setText(" You have: $" + Double.toString(player.getAmount()));
                        betAmount.setDisable(true);
                        bet.setDisable(true);
                        dCard1.setImage(new Image(getClass().getResource("images/back.jpg").toExternalForm()));
                        print(dealer, 1, dCard2);
                        print(player, 0, pCard1);
                        print(player, 1, pCard2);
                        hit.setDisable(false);
                        stand.setDisable(false);
                        playerCard.setText("Player's Hand: " + Integer.toString(player.calculate()) + " points");
                        if(player.getHand().size()==5){
                            hit.setDisable(true);
                        }

                    } catch (IllegalArgumentException e) {
                        alert.setAlertType(Alert.AlertType.ERROR);
                        alert.setTitle("Data Entry Error");
                        alert.setHeaderText("Invalid Value Entered");
                        alert.setContentText("Amount must be its correct type");
                        alert.show();
                    }
                }
            }
        });

        hit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                player.hit(dealer.getDeck());
                int i = player.getHand().size() - 1;
                if (i == 2) {
                    print(player, 2, pCard3);
                    pHand.getChildren().add(pCard3);
                }
                if (i == 3) {
                    print(player, 3, pCard4);
                    pHand.getChildren().add(pCard4);
                }
                if (i == 4) {
                    print(player, 4, pCard5);
                    pHand.getChildren().add(pCard5);
                }
                playerCard.setText("Player's Hand: " + Integer.toString(player.calculate()) + " points");
                if (player.getHand().size() == 5) {
                    hit.setDisable(true);
                    stand.setDisable(true);
                    bet.setDisable(true);
                    while (dealer.calculate() <= 17) {
                        dealer.hit(dealer.getDeck());
                    }
                    dHand.getChildren().removeAll(dCard1, dCard2);
                    print(dealer, 0, dCard1);
                    print(dealer, 1, dCard2);
                    dHand.getChildren().addAll(dCard1, dCard2);
                    int j = dealer.getHand().size() - 1;
                    if (j == 2) {
                        print(dealer, 2, dCard3);
                        dHand.getChildren().add(dCard3);
                    }
                    if (j == 3) {
                        print(dealer, 3, dCard4);
                        dHand.getChildren().add(dCard4);
                    }
                    if (j == 4) {
                        print(dealer, 4, dCard5);
                        dHand.getChildren().add(dCard5);
                    }
                    dealerCard.setText("Dealer's Hand: " + Integer.toString(dealer.calculate()) + " points");
                    declareWinner(player, dealer, player.getBet(), alert);
                    playAmount.setText(" You have: $" + Double.toString(player.getAmount()));
                }

            }
        });

        stand.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                hit.setDisable(true);
                stand.setDisable(true);
                bet.setDisable(true);
                if (player.getHand().size() == 2) {
                    while (dealer.calculate() <= 17) {
                        dealer.hit(dealer.getDeck());
                    }
                }
                if (player.getHand().size() >= 3) {
                    while (dealer.calculate() <= 15) {
                        dealer.hit(dealer.getDeck());
                    }
                }

                print(dealer, 0, dCard1);
                print(dealer, 1, dCard2);

                int j = dealer.getHand().size() - 1;
                if (j == 2) {
                    print(dealer, 2, dCard3);
                    dHand.getChildren().add(dCard3);
                }
                if (j == 3) {
                    print(dealer, 3, dCard4);
                    dHand.getChildren().add(dCard4);
                }
                if (j == 4) {
                    print(dealer, 4, dCard5);
                    dHand.getChildren().add(dCard5);
                }
                dealerCard.setText("Dealer's Hand: " + Integer.toString(dealer.calculate()) + " points");
                declareWinner(player, dealer, player.getBet(), alert);
                playAmount.setText(" You have: $" + Double.toString(player.getAmount()));

            }
        });

        newRound.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                newRound.setDisable(true);
                if (player.getAmount() > 0) {
                    game.deal();
                    dealerCard.setText("Dealer's Hand: ");
                    playerCard.setText("Player's Hand: ");
                    bet.setDisable(false);
                    betAmount.setText("");
                    betAmount.setDisable(false);
                    hit.setDisable(true);
                    stand.setDisable(true);
                    dCard1.setImage(null);
                    dCard2.setImage(null);
                    pCard1.setImage(null);
                    pCard2.setImage(null);
                    dHand.getChildren().removeAll(dCard3, dCard4, dCard5);
                    pHand.getChildren().removeAll(pCard3, pCard4, pCard5);
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Exit");
                    alert.setHeaderText("Insufficient Fund!!!");
                    alert.setContentText("You are broke!!! Please leave!!!");
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        System.exit(0);
                    }
                }
            }
        });

        quit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit");
                alert.setHeaderText("Quit Xi Dach");
                alert.setContentText("Are you sure you want to quit the game?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    System.exit(0);
                }
            }
        });
    }

    //validate black jack
    public boolean blackJack(Player player) {
        boolean blackJack = false;
        if (player.getHand().size() == 2 && player.getHand().getCard(0).getValue().name().equalsIgnoreCase("ace")
                && player.getHand().getCard(1).getValue().name().equalsIgnoreCase("ace")) {
            blackJack = true;
        }
        return blackJack;
    }

    //validate lucky 5
    public boolean luckyFive(Player player) {
        boolean luckyFive = false;
        if (player.getHand().size() == 5 && player.calculate() <= 21) {
            luckyFive = true;
        }
        return luckyFive;
    }

    public void declareWinner(Player player, Dealer dealer, double bet, Alert alert) {
        //decide who wins
        if (blackJack(player) == true && blackJack(dealer) == true) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Draw");
            alert.setHeaderText("It's a Draw!");
            alert.setContentText("You got $" + bet + " back!!!");
            alert.show();
            player.addAmount(bet);

        }
        if (blackJack(player) == true && blackJack(dealer) == false) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Won");
            alert.setHeaderText("Won by BlackJack!!! Double the bet!!!");
            alert.setContentText("You won $" + bet * 2 + "!!!");
            alert.show();
            player.addAmount(bet * 3);

        }
        if (blackJack(player) == false && blackJack(dealer) == true) {
            alert.setAlertType(Alert.AlertType.INFORMATION);
            alert.setTitle("Lost");
            alert.setHeaderText("Lost by BlackJack!!! Double the bet!!!");
            alert.setContentText("You lost $" + bet * 2 + "!!!");
            alert.show();
            player.removeAmount(bet);

        }
        if (blackJack(player) == false && blackJack(dealer) == false) {
            if (luckyFive(player) == true && luckyFive(dealer) == true) {
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Draw");
                alert.setHeaderText("It's a Draw!");
                alert.setContentText("You got $" + bet + " back!!!");
                alert.show();
                player.addAmount(bet);

            }
            if (luckyFive(player) == true && luckyFive(dealer) == false) {
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Won");
                alert.setHeaderText("Won by Lucky Five!!! Double the bet!!!");
                alert.setContentText("You won $" + bet * 2 + "!!!");
                alert.show();
                player.addAmount(bet * 3);

            }
            if (luckyFive(player) == false && luckyFive(dealer) == true) {
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setTitle("Lost");
                alert.setHeaderText("Lost by Lucky Five!!! Double the bet!!!");
                alert.setContentText("You lost $" + bet * 2 + "!!!");
                alert.show();
                player.removeAmount(bet);

            }
            if (luckyFive(player) == false && luckyFive(dealer) == false) {
                if (dealer.calculate() == player.calculate() || (dealer.calculate() > 21
                        && player.calculate() > 21) || (dealer.calculate() > 21 && player.calculate() < 15)) {
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Draw");
                    alert.setHeaderText("It's a Draw!");
                    alert.setContentText("You got $" + bet + " back!!!");
                    alert.show();
                    player.addAmount(bet);

                }
                if (player.calculate() <= 21 && player.calculate() > dealer.calculate()) {
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Won");
                    alert.setHeaderText("You Won!!!");
                    alert.setContentText("You won $" + bet + "!!!");
                    alert.show();
                    player.addAmount(bet * 2);

                }
                if (dealer.calculate() <= 21 && dealer.calculate() > player.calculate()) {
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Lost");
                    alert.setHeaderText("You Lost!!!");
                    alert.setContentText("You lost $" + bet + "!!!");
                    alert.show();

                }
                if ((player.calculate() <= 21 && player.calculate() > 15) && dealer.calculate() > 21) {
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Won");
                    alert.setHeaderText("You Won!!!");
                    alert.setContentText("You won $" + bet + "!!!");
                    alert.show();
                    player.addAmount(bet * 2);

                }
                if (dealer.calculate() <= 21 && (player.calculate() > 21 || player.calculate() < 15)) {
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Lost");
                    alert.setHeaderText("You Lost!!!");
                    alert.setContentText("You lost $" + bet + "!!!");
                    alert.show();

                }
            }
        }
        newRound.setDisable(false);
    }

    public void print(Player player, int i, ImageView view) {

        switch (player.getHand().getCard(i).getValue().name() + player.getHand().getCard(i).getSuit().name()) {
            case "ACEHEARTS":
                view.setImage(new Image(getClass().getResource("images/AH.jpg").toExternalForm()));
                break;
            case "ACEDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/AD.jpg").toExternalForm()));
                break;
            case "ACECLUBS":
                view.setImage(new Image(getClass().getResource("images/AC.jpg").toExternalForm()));
                break;
            case "ACESPADES":
                view.setImage(new Image(getClass().getResource("images/AS.jpg").toExternalForm()));
                break;

            case "TWOHEARTS":
                view.setImage(new Image(getClass().getResource("images/2H.jpg").toExternalForm()));
                break;
            case "TWODIAMONDS":
                view.setImage(new Image(getClass().getResource("images/2D.jpg").toExternalForm()));
                break;
            case "TWOCLUBS":
                view.setImage(new Image(getClass().getResource("images/2C.jpg").toExternalForm()));
                break;
            case "TWOSPADES":
                view.setImage(new Image(getClass().getResource("images/2S.jpg").toExternalForm()));
                break;

            case "THREEHEARTS":
                view.setImage(new Image(getClass().getResource("images/3H.jpg").toExternalForm()));
                break;
            case "THREEDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/3D.jpg").toExternalForm()));
                break;
            case "THREECLUBS":
                view.setImage(new Image(getClass().getResource("images/3C.jpg").toExternalForm()));
                break;
            case "THREESPADES":
                view.setImage(new Image(getClass().getResource("images/3S.jpg").toExternalForm()));
                break;

            case "FOURHEARTS":
                view.setImage(new Image(getClass().getResource("images/4H.jpg").toExternalForm()));
                break;
            case "FOURDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/4D.jpg").toExternalForm()));
                break;
            case "FOURCLUBS":
                view.setImage(new Image(getClass().getResource("images/4C.jpg").toExternalForm()));
                break;
            case "FOURSPADES":
                view.setImage(new Image(getClass().getResource("images/4S.jpg").toExternalForm()));
                break;

            case "FIVEHEARTS":
                view.setImage(new Image(getClass().getResource("images/5H.jpg").toExternalForm()));
                break;
            case "FIVEDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/5D.jpg").toExternalForm()));
                break;
            case "FIVECLUBS":
                view.setImage(new Image(getClass().getResource("images/5C.jpg").toExternalForm()));
                break;
            case "FIVESPADES":
                view.setImage(new Image(getClass().getResource("images/5S.jpg").toExternalForm()));
                break;

            case "SIXHEARTS":
                view.setImage(new Image(getClass().getResource("images/6H.jpg").toExternalForm()));
                break;
            case "SIXDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/6D.jpg").toExternalForm()));
                break;
            case "SIXCLUBS":
                view.setImage(new Image(getClass().getResource("images/6C.jpg").toExternalForm()));
                break;
            case "SIXSPADES":
                view.setImage(new Image(getClass().getResource("images/6S.jpg").toExternalForm()));
                break;

            case "SEVENHEARTS":
                view.setImage(new Image(getClass().getResource("images/7H.jpg").toExternalForm()));
                break;
            case "SEVENDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/7D.jpg").toExternalForm()));
                break;
            case "SEVENCLUBS":
                view.setImage(new Image(getClass().getResource("images/7C.jpg").toExternalForm()));
                break;
            case "SEVENSPADES":
                view.setImage(new Image(getClass().getResource("images/7S.jpg").toExternalForm()));
                break;

            case "EIGHTHEARTS":
                view.setImage(new Image(getClass().getResource("images/8H.jpg").toExternalForm()));
                break;
            case "EIGHTDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/8D.jpg").toExternalForm()));
                break;
            case "EIGHTCLUBS":
                view.setImage(new Image(getClass().getResource("images/8C.jpg").toExternalForm()));
                break;
            case "EIGHTSPADES":
                view.setImage(new Image(getClass().getResource("images/8S.jpg").toExternalForm()));
                break;

            case "NINEHEARTS":
                view.setImage(new Image(getClass().getResource("images/9H.jpg").toExternalForm()));
                break;
            case "NINEDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/9D.jpg").toExternalForm()));
                break;
            case "NINECLUBS":
                view.setImage(new Image(getClass().getResource("images/9C.jpg").toExternalForm()));
                break;
            case "NINESPADES":
                view.setImage(new Image(getClass().getResource("images/9S.jpg").toExternalForm()));
                break;

            case "TENHEARTS":
                view.setImage(new Image(getClass().getResource("images/10H.jpg").toExternalForm()));
                break;
            case "TENDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/10D.jpg").toExternalForm()));
                break;
            case "TENCLUBS":
                view.setImage(new Image(getClass().getResource("images/10C.jpg").toExternalForm()));
                break;
            case "TENSPADES":
                view.setImage(new Image(getClass().getResource("images/10S.jpg").toExternalForm()));
                break;

            case "JACKHEARTS":
                view.setImage(new Image(getClass().getResource("images/JH.jpg").toExternalForm()));
                break;
            case "JACKDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/JD.jpg").toExternalForm()));
                break;
            case "JACKCLUBS":
                view.setImage(new Image(getClass().getResource("images/JC.jpg").toExternalForm()));
                break;
            case "JACKSPADES":
                view.setImage(new Image(getClass().getResource("images/JS.jpg").toExternalForm()));
                break;

            case "QUEENHEARTS":
                view.setImage(new Image(getClass().getResource("images/QH.jpg").toExternalForm()));
                break;
            case "QUEENDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/QD.jpg").toExternalForm()));
                break;
            case "QUEENCLUBS":
                view.setImage(new Image(getClass().getResource("images/QC.jpg").toExternalForm()));
                break;
            case "QUEENSPADES":
                view.setImage(new Image(getClass().getResource("images/QS.jpg").toExternalForm()));
                break;

            case "KINGHEARTS":
                view.setImage(new Image(getClass().getResource("images/KH.jpg").toExternalForm()));
                break;
            case "KINGDIAMONDS":
                view.setImage(new Image(getClass().getResource("images/KD.jpg").toExternalForm()));
                break;
            case "KINGCLUBS":
                view.setImage(new Image(getClass().getResource("images/KC.jpg").toExternalForm()));
                break;
            case "KINGSPADES":
                view.setImage(new Image(getClass().getResource("images/KS.jpg").toExternalForm()));
                break;
            default:
                view.setImage(new Image(getClass().getResource("images/back.jpg").toExternalForm()));
        }
    }

}
