//package com.arayeh.hampa;
//
//import android.content.Context;
//import android.net.Uri;
//import android.os.Bundle;
//
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class TopFragment extends Fragment implements SelectItemClick {
//
//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager layoutManager;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_top, container, false);
//        recyclerView = view.findViewById(R.id.fl_recycler_view);
//       // recyclerView.setHasFixedSize(true);
//        recyclerView.setNestedScrollingEnabled(false);
//        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//        List<ContentItem> newsItems;
//        newsItems = new ArrayList<>();
//        newsItems.add(new ContentItem("تولد نوزاد ۵۰۰ گرمی در قم"
//                , "زن باردار قمی در هفته بیست و پنجم بارداری نوزاد دختری با وزن ۵۰۰ گرم به دنیا آورد.نوزادی که بعد از چند روز به وزن ۳ کیلوگرم رسید و از بیمارستان مرخص شد...", R.drawable.ic_baby_food, R.drawable.ic_baby_food));
//        newsItems.add(new ContentItem("وجود سم آفلاتوکسین درشیر پاستوریزه واقعیت دارد؟"
//                , "چند روز پیش ویدیویی از یک گفت و گو در شبکه سه سیما منتشر شد که در آن از آلودگی شیرهای پاستوریزه گفته شد و مجری برنامه هم از مردم خواست فعلا شیر نخورند...", R.drawable.ic_corona, R.drawable.ic_corona));
//        newsItems.add(new ContentItem("توصیه\u200Cهای طب سنتی برای دختردار شدن",
//                "مهم نیست بچه دختر باشد یا پسر، خدا کند سالم باشد» این جمله را حتما از دهان خیلی از مادر\u200Cها " + "و مادر\u200Cبزرگ\u200Cها شنیده\u200Cاید که برای دختر یا نوه" +
//                        "\u200Cدختری باردار\u200Cشان دعا می\u200Cکنند...", R.drawable.ic_sick_second, R.drawable.ic_sick_second));
//        newsItems.add(new ContentItem("7 راه افزایش رشد مغزی کودک"
//                , "یکی از مواردی که والدین به آن توجه می\u200Cکنند راههای افزایش ضریب هوشی و رشد مغزی کودک است. آنها" +
//                " می\u200Cخواهند فرزندشان باهوش باشد و از زمان بارداری و بعد از تولد به دنبال راه\u200Cهای رسیدن به این مطلوب هستند...", R.drawable.ic_gences, R.drawable.ic_gences));
//        mAdapter = new RecyclerViewAdapter(newsItems,this);
//        recyclerView.setAdapter(mAdapter);
//        return view;
//
//    }
//
//    @Override
//    public void onItemClick(int groupID, int id) {
//
//    }
//
//    @Override
//    public void onItemClick(int groupID, ContentItem contentItem) {
//
//    }
//}
