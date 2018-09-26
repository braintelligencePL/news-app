package pl.braintelligence.requirement.task.domain.values;

public enum Language {
    AR,
    DE,
    EN,
    ES,
    FR,
    HE,
    IT,
    NL,
    NO,
    PT,
    RU,
    SE,
    UD,
    ZH,
    INVALID;

    public boolean isInvalid() {
        return this == INVALID;
    }
}
