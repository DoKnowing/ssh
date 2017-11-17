package client.actionInterface;

import java.awt.*;
import java.io.IOException;

public interface CreateImageActionInter {
    String createRandom();

    void drawBackground(Graphics g);

    void drawRands(Graphics g, String rands);

    String create() throws IOException;
}
