package org.booleanfloat.treasuretrailer.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeItem {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:41.0) Gecko/20100101 Firefox/41.0";
    private static final String API_PATTERN = "http://services.runescape.com/m=itemdb_%s/api/catalogue/detail.json?item=%d";
    private static final Pattern PATTERN = Pattern.compile(
            "\\{\"item\":\\{" +
            "\"icon\":\"(.+)\"," +
            "\"icon_large\":\"(.+)\"," +
            "\"id\":(\\d+)," +
            "\"type\":\"(.+)\"," +
            "\"typeIcon\":\"(.+)\"," +
            "\"name\":\"(.+)\"," +
            "\"description\":\"(.+)\"," +
            "\"current\":\\{\"trend\":\"(positive|neutral|negative)\",\"price\":(\\d+)}," +
            "\"today\":\\{\"trend\":\"(positive|neutral|negative)\",\"price\":\"?(.+)\"?}," +
            "\"members\":\"(true|false)\"," +
            "\"day30\":\\{\"trend\":\"(positive|neutral|negative)\",\"change\":\"([\\-\\+]?\\d+\\.\\d+%)\"}," +
            "\"day90\":\\{\"trend\":\"(positive|neutral|negative)\",\"change\":\"([\\-\\+]?\\d+\\.\\d+%)\"}," +
            "\"day180\":\\{\"trend\":\"(positive|neutral|negative)\",\"change\":\"([\\-\\+]?\\d+\\.\\d+%)\"}}}"
    );
    private static Map<Integer, GeItem> cache = new HashMap<Integer, GeItem>();
    private static Map<Integer, String> jsonCache = new HashMap<Integer, String>();

    private final String icon, largeIcon, type, typeIcon, name, currentTrend, trendToday, description,
            day30Trend, day90Trend, day180Trend;
    private final int id, price, changeToday;
    private final double day30Change, day90Change, day180Change;
    private final boolean members;

    public GeItem(
            String icon, String largeIcon, int id, String type, String typeIcon, String name, String description,
            String currentTrend, int price, String trendToday, int changeToday, boolean members,
            String day30Trend, double day30Change, String day90Trend, double day90Change, String day180Trend, double day180Change
    ) {
        this.icon = icon;
        this.largeIcon = largeIcon;
        this.id = id;
        this.type = type;
        this.typeIcon = typeIcon;
        this.name = name;
        this.description = description;
        this.currentTrend = currentTrend;
        this.price = price;
        this.trendToday = trendToday;
        this.changeToday = changeToday;
        this.members = members;
        this.day30Trend = day30Trend;
        this.day30Change = day30Change;
        this.day90Trend = day90Trend;
        this.day90Change = day90Change;
        this.day180Trend = day180Trend;
        this.day180Change = day180Change;
    }

    public static GeItem getRT4(final int id) {
        if (!cache.containsKey(id)) {
            cache.put(id, get(id, "oldschool"));
        }
        return cache.get(id);
    }

    public static GeItem getRT6(final int id) {
        if (!cache.containsKey(id)) {
            cache.put(id, get(id, "rs"));
        }
        return cache.get(id);
    }

    private static GeItem get(final int id, final String itemdb) {
        if (!jsonCache.containsKey(id)) {
            jsonCache.put(id, getValue(id, itemdb));
        }

//        PATTERN.matcher("").matches()

        Matcher matcher = PATTERN.matcher(jsonCache.get(id));
        if (matcher.find()) {
            return new GeItem(
                    matcher.group(1), matcher.group(2), //icon, large icon
                    Integer.parseInt(matcher.group(3)), //id
                    matcher.group(4), matcher.group(5), //type, type icon
                    matcher.group(6), matcher.group(7), //name, description
                    matcher.group(8), Integer.parseInt(matcher.group(9)), //current trend, current price
                    matcher.group(10), 0, //today's trend, price change today
                    Boolean.valueOf(matcher.group(12)), //members
                    matcher.group(13), Double.parseDouble(matcher.group(14).replace("%", "")), //30 day trend, 30 day change
                    matcher.group(15), Double.parseDouble(matcher.group(16).replace("%", "")), //90 day trend, 90 day change
                    matcher.group(17), Double.parseDouble(matcher.group(18).replace("%", "")) //180 day trend, 180 day change
            );
        }
        return new GeItem("", "", -1, "", "", "", "", "", 0, "", 0, false, "", 0, "", 0, "", 0);
    }

    private static String getValue(final int id, String itemdb) {
        final String address = String.format(API_PATTERN, itemdb, id);
        String text = "";
        BufferedReader in = null;
        try {
            final URL url = new URL(address);
            final URLConnection con = url.openConnection();
            con.addRequestProperty("User-Agent", USER_AGENT);
            con.addRequestProperty("Connection", "close");
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String s;
            while ((s = in.readLine()) != null) {
                text = text.concat(s);
            }
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException ignored) {
            }
        }
        return text;
    }

    public String getIcon() {
        return icon;
    }

    public String getLargeIcon() {
        return largeIcon;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public int getChangeToday() {
        return changeToday;
    }

    public String getDay30Trend() {
        return day30Trend;
    }

    public double getDay30Change() {
        return day30Change;
    }

    public String getDay90Trend() {
        return day90Trend;
    }

    public double getDay90Change() {
        return day90Change;
    }

    public String getDay180Trend() {
        return day180Trend;
    }

    public double getDay180Change() {
        return day180Change;
    }

    public String getTypeIcon() {
        return typeIcon;
    }

    public String getCurrentTrend() {
        return currentTrend;
    }

    public String getTrendToday() {
        return trendToday;
    }

    public boolean isMembers() {
        return members;
    }

    @Override
    public String toString() {
        return String.format(
                "{name: %s, id: %d, price: %d, members: %s, type: %s, description: %s, " +
                        "today:{trend: %s, change: %d}, " +
                        "30 days:{trend: %s, change: %.2f}, " +
                        "90 days:{trend: %s, change: %.2f}, " +
                        "180 days:{trend: %s, change: %.2f}}",
                getName(), getId(), getPrice(), isMembers(), getType(), getDescription(),
                getTrendToday(), getChangeToday(), getDay30Trend(), getDay30Change(),
                getDay90Trend(), getDay90Change(), getDay180Trend(), getDay180Change()
        );
    }
}