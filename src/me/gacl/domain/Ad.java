package me.gacl.domain;

public class Ad {
    public int AdId;
    public String AdHead;
    public String AdP;
    public String AdBackgroud;
    public String AdHyperlink;

    public String getAdHyperlink() {
        return AdHyperlink;
    }

    public void setAdHyperlink(String adHyperlink) {
        AdHyperlink = adHyperlink;
    }

    public int getAdId() {
        return AdId;
    }

    public void setAdId(int adId) {
        AdId = adId;
    }

    public String getAdHead() {
        return AdHead;
    }

    public void setAdHead(String adHead) {
        AdHead = adHead;
    }

    public String getAdP() {
        return AdP;
    }

    public void setAdP(String adP) {
        AdP = adP;
    }

    public String getAdBackgroud() {
        return AdBackgroud;
    }

    public void setAdBackgroud(String adBackgroud) {
        AdBackgroud = adBackgroud;
    }
}
