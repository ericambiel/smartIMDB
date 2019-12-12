package ericambiel.com.br.smartimdb.ui.listafilmes;

import java.util.List;

import ericambiel.com.br.smartimdb.data.model.Filme;
import ericambiel.com.br.smartimdb.data.model.Video;

/**
 * Interface responsavel por designar Presenters e Views as classes (MVP).
 */
public interface ContratoFilme {
    /**
     * Interface a ser extendia para todas as Views.
     * Comum a todas as Views.
     */
    interface View {

    }

    interface ViewFilmesPopulares extends View{
        /**
         * Comtem lista de filmes populares a serem exibidos.
         * @param filmeList lista com filmes a serem exibidos.
         */
        void mostraFilmesPopulares (List<Filme> filmeList);

//        /**
//         * Comtem lista de trailers a serem exibidos.
//         * @param videoList lista com trailers a serem exibidos.
//         */
//        void mostraTrailers (List<Video> videoList);

        /**
         * Exibe player do YouTube em novo Fragmento
         * @param videoList lista de videos a serem executados
         */
        void iniciaYoutubePlayer(List<Video> videoList);

        /**
         * Exibe erro caso haja problemas de comunicação entre app e endpoints TMDB.
         */
        void mostraErro();
    }

    /**
     * Interface a ser extendia para todas os Presenters.
     * Comum a todos os Presenters.
     */
    interface Presenter{
        /**
         * Evita que um presenter fique orfão de uma View.
         */
        void destruirView();
    }

    interface PresenterFilmesPopulares extends Presenter {
        /**
         * Obtem filmes da API TMDB.
         */
        void obtemFilmesPopulares();

        /**
         * Obtem Videos de Filmes como trailes e teasers
         */
        void obtemVideos(Filme filme);
    }
}
