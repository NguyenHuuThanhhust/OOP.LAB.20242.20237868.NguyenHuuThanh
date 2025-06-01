package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class ItemController {

    private Media media;
    private Cart cart;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    public ItemController() {
        // Bắt buộc có constructor rỗng nếu cần khởi tạo từ FXML
    }

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        String icon = "";
        if (media instanceof hust.soict.hedspi.aims.media.Book) {
            icon = "📚 ";
        } else if (media instanceof hust.soict.hedspi.aims.media.CompactDisc) {
            icon = "💿 ";
        } else if (media instanceof hust.soict.hedspi.aims.media.DigitalVideoDisc) {
            icon = "🎬 ";
        }
        lblTitle.setText(icon + media.getTitle());
        
        lblCost.setText(String.format("%.2f $", media.getCost()));

        if (media instanceof Playable) {
        	btnPlay.setVisible(media instanceof Playable);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }


    @FXML
    private void btnAddToCartClicked(ActionEvent event) {
        if (cart != null && media != null) {
            cart.addMedia(media);
            System.out.println("✅ Added to cart: " + media.getTitle());
        } else {
            System.err.println("❌ Cannot add to cart: media or cart is null.");
        }
    }

    @FXML
    private void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            try {
                Playable playable = (Playable) media;
                playable.play();  

                StringBuilder content = new StringBuilder();
                content.append("🎵 Now Playing: ").append(media.getTitle()).append("\n\n")
                       .append("📁 Category: ").append(media.getCategory()).append("\n")
                       .append("⏱ Duration: ");

                if (media instanceof hust.soict.hedspi.aims.media.CompactDisc) {
                    content.append(((hust.soict.hedspi.aims.media.CompactDisc) media).getLength()).append(" minutes");
                } else if (media instanceof hust.soict.hedspi.aims.media.DigitalVideoDisc) {
                    content.append(((hust.soict.hedspi.aims.media.DigitalVideoDisc) media).getLength()).append(" minutes");
                } else {
                    content.append("N/A");
                }

                content.append("\n💰 Cost: ").append(String.format("%.2f $", media.getCost()));

                                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Now Playing");
                alert.setHeaderText("💿 Media Playback");
                alert.setContentText(content.toString());

                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.setStyle("-fx-font-size: 14px; -fx-font-family: 'Segoe UI';");
                alert.showAndWait();

            } catch (PlayerException e) {
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setTitle("Playback Error");
                errorAlert.setHeaderText("Cannot play media");
                errorAlert.setContentText(e.getMessage());
                errorAlert.showAndWait();
            }
        }
    }
}
