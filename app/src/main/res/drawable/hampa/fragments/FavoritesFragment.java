package com.arayeh.hampa.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arayeh.hampa.R;
import com.arayeh.hampa.models.NewsItem;
import com.arayeh.hampa.utils.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.fragment_favorites, container, false);
        recyclerView= v.findViewById(R.id.fl_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        List<NewsItem> newsItems;
        newsItems = new ArrayList<>();
        newsItems.add(new NewsItem("تولد نوزاد ۵۰۰ گرمی در قم"
               , "زن باردار قمی در هفته بیست و پنجم بارداری نوزاد دختری با وزن ۵۰۰ گرم به دنیا آورد.نوزادی که بعد از چند روز به وزن ۳ کیلوگرم رسید و از بیمارستان مرخص شد...", R.drawable.ic_baby_food, R.drawable.ic_baby_food));
        newsItems.add(new NewsItem("وجود سم آفلاتوکسین درشیر پاستوریزه واقعیت دارد؟"
                , "چند روز پیش ویدیویی از یک گفت و گو در شبکه سه سیما منتشر شد که در آن از آلودگی شیرهای پاستوریزه گفته شد و مجری برنامه هم از مردم خواست فعلا شیر نخورند...", R.drawable.ic_corona, R.drawable.ic_corona));
        newsItems.add(new NewsItem("توصیه\u200Cهای طب سنتی برای دختردار شدن",
                "مهم نیست بچه دختر باشد یا پسر، خدا کند سالم باشد» این جمله را حتما از دهان خیلی از مادر\u200Cها "+"و مادر\u200Cبزرگ\u200Cها شنیده\u200Cاید که برای دختر یا نوه" +
                        "\u200Cدختری باردار\u200Cشان دعا می\u200Cکنند...", R.drawable.ic_sick_second, R.drawable.ic_sick_second));
        newsItems.add(new NewsItem("7 راه افزایش رشد مغزی کودک"
                , "یکی از مواردی که والدین به آن توجه می\u200Cکنند راههای افزایش ضریب هوشی و رشد مغزی کودک است. آنها" +
                " می\u200Cخواهند فرزندشان باهوش باشد و از زمان بارداری و بعد از تولد به دنبال راه\u200Cهای رسیدن به این مطلوب هستند...", R.drawable.ic_gences, R.drawable.ic_gences));
        mAdapter = new RecyclerViewAdapter(newsItems);
        recyclerView.setAdapter(mAdapter);
        return v;
    }
    @Override
    public void onDestroy() {

        super.onDestroy();
    }
}
