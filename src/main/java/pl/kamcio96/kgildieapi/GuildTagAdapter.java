package pl.kamcio96.kgildieapi;

import com.google.common.base.Optional;

/**
 * Podstawowy system tagow gildyjnych
 * W razie wątpliwości lub problemów napisz ;)
 */
public interface GuildTagAdapter {

    /**
     * Wykonuje sie gdy gracze z tej samej gildi zobacza sie
     * Zwraca obiekt z prefixem i suffixem ktory powinien byc ustawiony
     * @param player gracz który widzi
     * @param namedPlayer gracz który jest widziany
     * @param guild gildia oby gracz (ta sama)
     * @return PlayerTag
     */
    public PlayerTag getOurTag(PlayerData player, PlayerData namedPlayer, Guild guild);

    /**
     * Wykonuje sie gdy gracz zobaczy kogoś kto ma gildie
     * Zwraca obiekt z prefixem i suffixem ktory powinien byc ustawiony
     * @param player gracz który widzi
     * @param playerGuild gildia gracza ktory widzi
     * @param namedPlayer gracz który jest widziany
     * @param namedPlayerGuild gildia gracza który jest widziany
     * @return PlayerTag
     */
    public PlayerTag getOtherTag(PlayerData player, Optional<Guild> playerGuild, PlayerData namedPlayer, Guild namedPlayerGuild);

    /**
     * Wykonuje sie gdy gracz zobaczy kogoś kto ma gildie z która jest zawarty sojusz
     * Zwraca obiekt z prefixem i suffixem ktory powinien byc ustawiony
     * @param player gracz który widzi
     * @param playerGuild gildia gracza ktory widzi
     * @param namedPlayer gracz który jest widziany
     * @param namedPlayerGuild gildia gracza który jest widziany
     * @return PlayerTag
     */
    public PlayerTag getAllianceTag(PlayerData player, Guild playerGuild, PlayerData namedPlayer, Guild namedPlayerGuild);

    /**
     * Wykonuje sie gdy gracz zobaczy kogoś kto nie ma gildi
     * Zwraca obiekt z prefixem i suffixem ktory powinien byc ustawiony
     * @param player gracz który widzi
     * @param playerGuild gildia gracza ktory widzi
     * @param namedPlayer gracz który jest widziany
     * @return PlayerTag
     */
    public PlayerTag getNoTag(PlayerData player, Optional<Guild> playerGuild, PlayerData namedPlayer);

    /**
     * Obrazuje klase która posiada prefix i suffix
     */
    interface PlayerTag {

        /**
         * Zwraca prefix ktory ma być ustawiony
         * @return prefix
         */
        public Optional<String> getPrefix();

        /**
         * Zwraca suffix ktory ma być ustawiony
         * @return prefix
         */
        public Optional<String> getSuffix();
    }
}
