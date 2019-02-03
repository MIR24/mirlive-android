package tv.mir24.mirlive.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import tv.mir24.mirlive.R;
import tv.mir24.mirlive.utilities.FlowTextHelper;

public class AboutActivity extends AppCompatActivity {

    static final String[] descriptions =
            {"Телеканал «Мир» знакомит зрителей с современной жизнью и историей стран бывшего Советского Союза, формирует культурные, социальные и экономические связи. Основу контента телеканала составляют информационно-аналитические, познавательные, развлекательные и публицистические программы, в том числе и для детей. Значительная часть эфира отведена художественным фильмам и сериалам.",
                    "Телеканал «Мир 24» — информационный, культурологический и страноведческий телеканал, который начал вещание 1 января 2013 года в 6:00 МСК, рассказывает о новостях в странах СНГ и в мире. Каждые полчаса в прямом эфире выходят 15-минутные выпуски оперативной информации, каждые 4 часа по будням — 25-минутные блоки новостей с репортажами, прямыми включениями и комментариями. Круглосуточно — информационные ленты в виде бегущей строки с «горящими» новостями и темами дня.",
                    "«Мир HD» — это развлекательно-познавательный телеканал высокой чёткости. Канал предлагает своим зрителям большое количество художественных фильмов и сериалов. В эфире «Мир HD» есть линейки западного и российского кино. Широко представлены программы о путешествиях, красоте и здоровье, ток-шоу, информационные и публицистические передачи, а также проекты для детей.",
                    "Радиостанция «Мир» вещает в музыкально-информационном формате. Каждые полчаса в эфире — эксклюзивные новости от собственных корреспондентов в странах СНГ и российских городах вещания. Основа музыкальной политики — песни 1990—2000-х годов на русском языке. Представлены также образовательные, литературно-художественные программы, ток-шоу, радиомосты со странами СНГ.",
                    "Версия телеканала «Мир» с временным сдвигом. Телеканал «Мир» знакомит зрителей с современной жизнью и историей стран бывшего Советского Союза, формирует культурные, социальные и экономические связи. Основу контента телеканала составляют информационно-аналитические, познавательные, развлекательные и публицистические программы, в том числе и для детей. Значительная часть эфира отведена художественным фильмам и сериалам."};
    static final String[] logos =
            {"mirtv_logo", "mir24_logo", "mirhd_logo", "radio_logo", "mirtv_logo"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        Intent i = getIntent();
        int id = i.getIntExtra("channelId", 0);
        String name = i.getStringExtra("channelName");

        TextView channelName = findViewById(R.id.channelName);
        channelName.setText(name);

        TextView channelDesc = findViewById(R.id.channelDesc);
        ImageView thumb = findViewById(R.id.inTextLogo);
        Drawable channelLogo = ContextCompat.getDrawable(getApplicationContext(),
                getResources().getIdentifier(logos[id], "drawable", getPackageName()));
        thumb.setImageDrawable(channelLogo);

        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        FlowTextHelper.tryFlowText(descriptions[id], thumb, channelDesc);
    }

}
