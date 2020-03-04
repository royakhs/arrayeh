package com.arayeh.hampa.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arayeh.hampa.R;
import com.arayeh.hampa.models.DataItem;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.fragment_favorites, container, false);
        recyclerView= v.findViewById(R.id.fl_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        List<DataItem> dataItems;
        dataItems = new ArrayList<>();
        dataItems.add(new DataItem("تولد نوزاد ۵۰۰ گرمی در قم"
                , "زن باردار قمی در هفته بیست و پنجم بارداری نوزاد دختری با وزن ۵۰۰ گرم به دنیا آورد.نوزادی که بعد از چند روز به وزن ۳ کیلوگرم رسید و از بیمارستان مرخص شد..."));
        dataItems.add(new DataItem("7 راه افزایش رشد مغزی کودک"
                , "یکی از مواردی که والدین به آن توجه می\u200Cکنند راههای افزایش ضریب هوشی و رشد مغزی کودک است. آنها می\u200Cخواهند فرزندشان باهوش باشد و از زمان بارداری و بعد از تولد به دنبال راه\u200Cهای رسیدن به این مطلوب هستند..."));
        dataItems.add(new DataItem("وجود سم آفلاتوکسین درشیر پاستوریزه واقعیت دارد؟"
                , "چند روز پیش ویدیویی از یک گفت و گو در شبکه سه سیما منتشر شد که در آن از آلودگی شیرهای پاستوریزه گفته شد و مجری برنامه هم از مردم خواست فعلا شیر نخورند..."));
        dataItems.add(new DataItem("توصیه\u200Cهای طب سنتی برای دختردار شدن", "مهم نیست بچه دختر باشد یا پسر، خدا کند سالم باشد» این جمله را حتما از دهان خیلی از مادر\u200Cها و مادر\u200Cبزرگ\u200Cها شنیده\u200Cاید که برای دختر یا نوه\u200Cدختری باردار\u200Cشان دعا می\u200Cکنند..."));
     //   mAdapter = new RecyclerViewAdapter(dataItems);
        recyclerView.setAdapter(mAdapter);


        return v;
    }
}
