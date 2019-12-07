package com.example.final_quiz_3.model.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.final_quiz_3.application.MyApplication;
import com.example.final_quiz_3.model.Question;
import com.example.final_quiz_3.model.Theme;
import com.example.final_quiz_3.model.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {
    private SQLiteDatabase sqLiteDatabase;

    public DatabaseAdapter(Context context) {
        FeedQuizDatabaseHelper mySQLiteOpenHelper = new FeedQuizDatabaseHelper(context);
        sqLiteDatabase = mySQLiteOpenHelper.getWritableDatabase();

        if (MyApplication.isFirstLaunch()) {
            populateDatabase();
            MyApplication.setFirstLaunch();
        }
    }

    private void populateDatabase() {
        Log.d("MY_LOG", "Pré-chargement de la base de données");
        addUser(new User("Sami", "Khalifa", "sami", "sami"));

        addTheme(new Theme("Informatique"));
        addTheme(new Theme("Culture Générale"));
        addTheme(new Theme("Histoire"));
        addTheme(new Theme("Inventions"));


        Theme informatique = new Theme(1, "Informatique");
        addQuestion(new Question(informatique, "Avec quel IDE programme t-on du C# ? ", new String[]{"Visual code", "Visual Studio", "IntelliJ", "Android Studio"}, 1, "C# est développé par Microsoft ! "));
        addQuestion(new Question(informatique, "Qu'est ce qu'un JDK ?", new String[]{"Java Devlopper kit", "Java Devloppement kit", "Java Document kit", "Java Directory kit"}, 1, "J veut dire Java"));
        addQuestion(new Question(informatique, "Combien d'OS existent sur pc ?", new String[]{"2", "4", "5", "3"}, 3, "Android n'est pas un OS Pc"));
        addQuestion(new Question(informatique, "Sur quoi est basé Windows ?", new String[]{"Linux", "Unix", "MacOS", "Inux"}, 1, "Windows et MacOS ont la méme source ! "));
        addQuestion(new Question(informatique, "En quelle année est sorti le premier appareil Android ? ",new String[]{"2003","2010","2004","2008"},3,"Android n,est pas sivieux que ça"));

        Theme CultureG = new Theme(2,"Culture Générale");
        addQuestion(new Question(CultureG,"Le mont Everest Mesure combien de Metres ?",new String[]{"6.245","8.848","9.884","8.428"},1,"c'est la plus grande chaine de montagne du monde ! "));
        addQuestion(new Question(CultureG,"Quel pays d'Afrique est le plus grand en terme de superficie ?",new String[]{"Algerie","Congo","Ethiopie","Nigeria"},0," Grace au désert l'Algerie dépasse le Congo de quelques km ! "));
        addQuestion(new Question(CultureG,"Quel pays est le plus peuplé du Monde ?",new String[]{"Japon","Russie","Inde","Chine"},3,"Il est Le plus peuplé avec bientot 2 Milliards d'habitants ! "));
        addQuestion(new Question(CultureG,"Quel Ville est le plus peuplée du Monde ?",new String[]{"Pekin","Sidney","Tokyo","New York"},2," Il y'a quasi 10 millions d'habitants a Tokyo ! "));
        addQuestion(new Question(CultureG,"Quel pays n'a pas de frontiere avec la Chine ?",new String[]{"Inde","Russie","Corée du Sud","Afganistan"},2,"La Corée du nord sépare la chine et la CDS ! "));

        Theme Hist = new Theme(3,"Histoire");
        addQuestion(new Question(Hist,"En quelle année la 'Prise de la Bastille' eut lieu ? ",new String[]{"1799","1889","1779","1789"},2,"Il fut trés Sanglant "));
        addQuestion(new Question(Hist,"En quelle année fut achevé la 'Reconquista' ? ",new String[]{"1492","1589","1441","1509"},0,"Il eut des conséquences improbables "));
        addQuestion(new Question(Hist,"En quelle année fut découvert l'Amérique ? ",new String[]{"1498","1492","1503","1590"},1,"Il eut des conséquences improbables "));
        addQuestion(new Question(Hist,"Lequel de ces Pays fut concerné par la 2e Guerre Mondiale ? ",new String[]{"Islande","Brezil","Pakistan","Lichtenstein"},3," -.- "));

        addQuestion(new Question(Hist,"De quel pays Gengis était le Khan(dirigeant)? ",new String[]{"Chine","Mongol","Japon","Philipines"},1," C'était un grand homme "));


        Theme inventions = new Theme(4, "Inventions");
        addQuestion(new Question(inventions, "Qui a réussi à imposer la commercialisation de la poubelle ?", new String[]{"Eugène Poubelle", "Louis Lépine", "Bertrand Landrieu", "Ferdinand Duval"}, 0, "Préfet de la Seine, il a donné son nom aux poubelles à travers ses décisions pour améliorer l'hygiène de la ville de Paris."));
        addQuestion(new Question(inventions, "Laquelle de ces inventions ne porte pas le nom de son inventeur ?", new String[]{"Le laser", "Le colt", "La poubelle", "Le macadam"}, 0, "En 1950, Alfred Kastler proposa un procédé de pompage optique qu'il valida expérimentalement deux ans plus tard."));
        addQuestion(new Question(inventions, "Quel jeu de société international Chris Haney et Scott Abbott ont-ils créé ?", new String[]{"Trivial Pursuit", "Monopoly", "Puissance 4", "Cluedo"}, 0, "Le jeu a été commercialisé en France sous le nom Remue-méninges avant de connaître le succès que nous lui connaissons."));
        addQuestion(new Question(inventions, "Qui a inventé la dynamite au moyen de la nitroglycérine ?", new String[]{"Alfred Nobel", "Albert Einstein", "Lavoisier", "Isaac Newton"}, 0, "La dynamite a été très utilisée, notamment dans l'industrie minière, jusqu'à son remplacement par des explosifs plus puissants."));
        addQuestion(new Question(inventions, "Quel inventeur italien a conçu à la fin du XVe siècle un canon et un parachute ?", new String[]{"Léonard de Vinci", "Roberto Galletti", "Ettore Bugatti", "Alessandro Volta"}, 0, "Léonard de Vinci a fait progresser la connaissance dans les domaines de l'anatomie, du génie civil, de l'optique et de l'hydrodynamique."));
        addQuestion(new Question(inventions, "Selon des textes anciens, dans quel pays a-t-on inventé le cerf-volant ?", new String[]{"En Chine", "En Inde", "Aux États-Unis", "Au Mexique"}, 0, "À l'origine, le cerf-volant servait de signal, mais aussi à porter des messages, à effrayer les ennemis ou à évaluer des distances."));
        addQuestion(new Question(inventions, "Quel billet le banquier Law a-t-il inventé au XVIIIe siècle ?", new String[]{"Le billet de banque", "Le billet de loterie", "Le billet doux", "Le billet notarial"}, 0, "John Law recommanda l'utilisation de papier-monnaie plutôt que de monnaie métallique afin de faciliter le commerce et l'investissement."));
        addQuestion(new Question(inventions, "Combien de brevets furent déposés par Thomas Edison au cours de sa vie ?", new String[]{"1 074", "57", "234", "421"}, 0, "Thomas Edison employa au cours de sa vie plus de 35 000 personnes dans son « empire industriel » fondé sur l'électricité."));
        addQuestion(new Question(inventions, "Louis Réard a inventé le bikini, mais quel était son véritable métier ?", new String[]{"Ingénieur automobile", "Barbier", "Charcutier", "Coiffeur"}, 0, "Il le présenta en 1946 à la piscine Molitor, porté par Micheline Bernardini, une danseuse nue bien connue du Casino de Paris."));
        addQuestion(new Question(inventions, "Quelle était la nationalité des deux ingénieurs inventeurs du carburateur ?", new String[]{"Hongroise", "Roumaine", "Suisse", "Autrichienne"}, 0, "Le carburateur permet de préparer un mélange d'air et de carburant pour constituer un mélange de richesse adéquate."));


    }

    public boolean checkUserCredentials(User user) {
        Cursor cursor = sqLiteDatabase.query(
                FeedQuiz.USER_TABLE_NAME,
                new String[]{FeedQuiz.USER_COLUMN_ID_USER},
                FeedQuiz.USER_COLUMN_NAME_USERNAME + "= ? AND " + FeedQuiz.USER_COLUMN_NAME_PASSWORD + "= ?",
                new String[]{user.getUsername(), user.getPassword()},
                null,
                null,
                null
        );

        boolean connected = cursor.moveToNext();
        cursor.close();
        return connected;
    }

    public boolean addUser(User user) {
        ContentValues values = new ContentValues();
        values.put(FeedQuiz.USER_COLUMN_NAME_FIRST_NAME, user.getFirstName());
        values.put(FeedQuiz.USER_COLUMN_NAME_LAST_NAME, user.getLastName());
        values.put(FeedQuiz.USER_COLUMN_NAME_USERNAME, user.getUsername());
        values.put(FeedQuiz.USER_COLUMN_NAME_PASSWORD, user.getPassword());

        long newRowId = sqLiteDatabase.insert(FeedQuiz.USER_TABLE_NAME, null, values);
        return newRowId != -1;
    }

    private boolean addTheme(Theme theme) {
        ContentValues values = new ContentValues();
        values.put(FeedQuiz.THEME_TABLE_NAME, theme.getName());

        long newRowId = sqLiteDatabase.insert(FeedQuiz.THEME_TABLE_NAME, null, values);
        return newRowId != -1;
    }

    public List<Theme> getThemes() {
        Cursor cursor = sqLiteDatabase.query(
                FeedQuiz.THEME_TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                FeedQuiz.THEME_TABLE_NAME + " ASC"
        );

        List<Theme> themes = new ArrayList<>();

        while (cursor.moveToNext()) {
            themes.add(new Theme(cursor.getInt(0), cursor.getString(1)));
        }

        cursor.close();
        return themes;
    }

    public List<Question> getQuestions(Theme theme) {
        Cursor cursor = sqLiteDatabase.query(
                FeedQuiz.QUESTION_TABLE_NAME,
                new String[]{
                        FeedQuiz.QUESTION_COLUMN_ID,
                        FeedQuiz.QUESTION_COLUMN_QUESTION,
                        FeedQuiz.QUESTION_COLUMN_PROPOSITION_1,
                        FeedQuiz.QUESTION_COLUMN_PROPOSITION_2,
                        FeedQuiz.QUESTION_COLUMN_PROPOSITION_3,
                        FeedQuiz.QUESTION_COLUMN_PROPOSITION_4,
                        FeedQuiz.QUESTION_COLUMN_GOOD_ANSWER,
                        FeedQuiz.QUESTION_COLUMN_ANECDOTE,
                },
                FeedQuiz.QUESTION_COLUMN_ID_THEME + "= ?",
                new String[]{String.valueOf(theme.getId())},
                null,
                null,
                null
        );

        List<Question> questions = new ArrayList<>();

        while (cursor.moveToNext()) {
            questions.add(new Question(
                    cursor.getInt(0),
                    theme,
                    cursor.getString(1),
                    new String[]{
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getString(5),
                    },
                    cursor.getInt(6),
                    cursor.getString(7))
            );
        }

        cursor.close();
        return questions;
    }

    private boolean addQuestion(Question question) {

        ContentValues values = new ContentValues();
        values.put(FeedQuiz.QUESTION_COLUMN_ID_THEME, question.getTheme().getId());
        values.put(FeedQuiz.QUESTION_COLUMN_QUESTION, question.getQuestion());
        values.put(FeedQuiz.QUESTION_COLUMN_PROPOSITION_1, question.getPropositions()[0]);
        values.put(FeedQuiz.QUESTION_COLUMN_PROPOSITION_2, question.getPropositions()[1]);
        values.put(FeedQuiz.QUESTION_COLUMN_PROPOSITION_3, question.getPropositions()[2]);
        values.put(FeedQuiz.QUESTION_COLUMN_PROPOSITION_4, question.getPropositions()[3]);
        values.put(FeedQuiz.QUESTION_COLUMN_GOOD_ANSWER, question.getIndexGoodAnswer());
        values.put(FeedQuiz.QUESTION_COLUMN_ANECDOTE, question.getAnecdote());

        long newRowId = sqLiteDatabase.insert(FeedQuiz.QUESTION_TABLE_NAME, null, values);
        return newRowId != -1;
    }
}
