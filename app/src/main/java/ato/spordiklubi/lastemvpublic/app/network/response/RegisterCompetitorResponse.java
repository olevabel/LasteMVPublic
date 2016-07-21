package ato.spordiklubi.lastemvpublic.app.network.response;

import java.io.Serializable;

import ato.spordiklubi.lastemvpublic.app.dto.Competitor;

public class RegisterCompetitorResponse implements Serializable {


    private Competitor competitor;

    public RegisterCompetitorResponse(Competitor competitor) {
        this.competitor = competitor;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }

    @Override
    public String toString() {
        return "RegisterCompetitorResponse{" +
                "competitor=" + competitor +
                '}';
    }
}
