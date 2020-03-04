package com.arayeh.hampa;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class BabyContextFragment extends Fragment {
private RecyclerView rvBabyContext;
private RecyclerView.LayoutManager layoutManager;
private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_baby_context, container, false);
        rvBabyContext=view.findViewById(R.id.rvContext);
        layoutManager= new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvBabyContext.setLayoutManager(layoutManager);
        rvBabyContext.setNestedScrollingEnabled(false);
        List<ContextItem> contentItemList=new ArrayList<>();
        contentItemList.add(new ContextItem("شیر خشک مخصوص نوزادان زیر 5 ماه"
                , "اینکه در هر ماه از زندگی نوزاد، انتظار چه اندازه رشد از او داشته باشید، می\u200Cتواند تا حدود زیادی نگرانی\u200Cتان را درباره رشد فیزیکی مطلوب نوزاد برطرف کند. اگر از همین حالا می\u200Cخواهید بدانید چه زمان نوزادتان قرار است بنشیند، راه برود، واکنش داشته باشد، بهتر است این اینفوگرافی را از دست ندهید. "));
        contentItemList.add(new ContextItem("حوله ی کودک 2 ماه تا 4 ماهه"
                , "در حالی که مردم جنوب سیستان و بلوچستان همچنان درحال کشف کیک های بسته بندی شده آلوده به قرص هستند، سرپرست مرکز بهداشت چابهار مدعی شد، تمامی موارد مشکوک جمع\u200Cآوری شده و حتی برای رسیدگی به موضوع پرونده قضایی تشکیل شده است."));
        contentItemList.add(new ContextItem("پستانک اوجینال مای بی  بی"
                , "جنین در رحم مادر، شب و روز در خواب به سر می برد، زیرا کار و فعالیت ندارد و تمام نیروی او بایستی صرف سازندگی شود و از طرف دیگر سلول های جوان و ناکامل او قادر به ایجاد و نگه داری نیروی زیاد نیست . لذا ۲۴ ساعت می خوابد و احتیاجات خود را از سرمی گیرد . اطفال نارس هم به همین علت بایستی زیاد بخوابند.\n" +
                "\n" +
                "پس از تولد نیز نوزاد نیاز شدیدی به خواب و استراحت کامل دارد و در روزهای اول تولد باید معمولا ۲۰ تا ۲۴ ساعت در خواب باشد، یعنی در ۲۴ ساعت شبانه روز فقط هنگام شیر خوردن بیدار شود و باقی ساعات در خواب باشد تا برای سازندگی نیرو ذخیره کند. این برنامه حداقل تا انتهای ماه اول تولد و یا روز چهلم ادامه خواهد داشت و اگر برنامه ی نوزادی غیر از این باشد، ممکن است دچار مشکلی باشد."));
        contentItemList.add(new ContextItem("پودر بچه 530 گرمی فیروز",
                "ابتلا به دیابت بارداری به این معنا نیست که شما قبل از بارداری دیابت داشته\u200Cاید یا بعد از زایمان هم دچار دیابت خواهید شد. با این\u200C حال دچار شدن به دیابت بارداری احتمال ابتلای شما را به دیابت نوع ۲ افزایش خواهد داد.\n" +
                        "\n" +
                        "علاوه\u200Cبراین با مراقبت نادرست، خطر ابتلای کودک\u200Cتان به دیابت افزایش می\u200Cیابد و در طول بارداری و زایمان احتمال ایجاد خطراتی در شما و کودک\u200Cتان بیشتر می\u200Cشود."));
        recyclerViewAdapter=new RecyclerViewAdapter(contentItemList);
        rvBabyContext.setAdapter(recyclerViewAdapter);

        return view;
    }


}
