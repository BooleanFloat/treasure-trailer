package org.booleanfloat.treasuretrailer.util;

import org.powerbot.script.rt4.ClientContext;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RewardItem {

    private ClientContext ctx;
    private int id;
    private int amount;
    private String name;
    private String description;
    private int price;
    private Image icon;

    private static final String API = "http://services.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0";
    private static final Pattern PATTERN = Pattern.compile((
            "\"icon\":\"(.+?)\".*?" +
            "\"id\":(\\d+).*" +
            "\"name\":\"(.+?)\".*" +
            "\"description\":\"(.+?)\".*?" +
            "\"price\":(.+?)\\}")
    );

    public RewardItem(ClientContext ctx, int id, int amount) {
        this.ctx = ctx;
        this.id = id;
        this.amount = amount;
        this.name = "[unknown]";
        this.description = "";
        this.price = 0;

        if(this.id == 995) {
            this.name = "Coins";
            this.description = "Lovely money!";
            this.price = 1;
            this.icon = null;
        }
        else {
            getGrandExchangeDate();
        }
    }

    private void getGrandExchangeDate() {
        String response = "";

        try {
            URL url = new URL(String.format(API, this.id));
            URLConnection connection = url.openConnection();

            connection.addRequestProperty("User-Agent", USER_AGENT);
            connection.addRequestProperty("Connection", "close");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String text;
            while((text = in.readLine()) != null) {
                response = response.concat(text);
            }

            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Matcher matcher = PATTERN.matcher(response);

        if(matcher.find()) {
            setIcon(matcher.group(1));
            setName(matcher.group(3));
            setDescription(matcher.group(4));
            setPrice(matcher.group(5));
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        price = price.replaceAll("\"", "");

        if(price.contains("b")) {
            this.price = (int) Double.parseDouble(price.replace("b", "").replace(",", ".")) * 1000000000;
        }
        else if(price.contains("m")) {
            this.price = (int) Double.parseDouble(price.replace("m", "").replace(",", ".")) * 1000000;
        }
        else if(price.contains("k")) {
            this.price = (int) Double.parseDouble(price.replace("k", "").replace(",", ".")) * 1000;
        }
        else if(price.contains(",")) {
            this.price = Integer.parseInt(price.replace(",", ""));
        }
        else {
            this.price = Integer.parseInt(price);
        }
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getValue() {
        return this.amount * this.price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public Image getIcon() {
        return this.icon;
    }

    public void setIcon(String url) {
        this.icon = ctx.controller.script().downloadImage(url);
    }

    public String toString() {
        return String.format("name: %s, amount: %d, value: %d", getName(), getAmount(), getValue());
    }
}
