package com.arayeh.hampa.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.arayeh.hampa.Interfaces.SelectItemClick;
import com.arayeh.hampa.MainActivity;
import com.arayeh.hampa.R;
import com.arayeh.hampa.models.NewsItem;
import com.arayeh.hampa.models.Slide;
import com.arayeh.hampa.utils.NewsViewAdapter;
import com.arayeh.hampa.utils.SecondNewsAdapter;
import com.arayeh.hampa.utils.SimpleLinkAdapter;
import com.arayeh.hampa.utils.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment implements SelectItemClick {
    private RecyclerView firstRecyclerView;
    private RecyclerView secondRecyclerView;
    private RecyclerView thirdRecyclerView;
    private RecyclerView fourthRecyclerView;
    private RecyclerView fifthRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.Adapter mSecondListAdapter;
    private RecyclerView.Adapter mThirdListAdapter;
    private RecyclerView.Adapter mFifthRecyclerAdapter;
    private TextView mfirstList;
//    private TextView mSecondList;
//    private TextView mThirdList;
//    private TextView mfourthList;
//    private TextView mfifthList;
    private ViewPager pager;
    private List<Slide> slides;
    private FragmentManager fragmentManager;
    private Timer timer;
    private RecyclerView.LayoutManager layoutManager;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        firstRecyclerView = view.findViewById(R.id.first_list_rv);
        secondRecyclerView = view.findViewById(R.id.second_list_rv);
        thirdRecyclerView = view.findViewById(R.id.third_list_rv);
        fourthRecyclerView = view.findViewById(R.id.fourth_list_rv);
        fifthRecyclerView = view.findViewById(R.id.fifth_list_rv);
        mfirstList=view.findViewById(R.id.firstList);

        pager = view.findViewById(R.id.pager);
        CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
        slides = new ArrayList<>();
        slides.add(new Slide(R.drawable.ic_baby_food));
        slides.add(new Slide(R.drawable.ic_baby_food));
        slides.add(new Slide(R.drawable.ic_baby_food));
        slides.add(new Slide(R.drawable.ic_baby_food));
        slides.add(new Slide(R.drawable.ic_baby_food));
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new SlideFragment(R.drawable.ic_baby_food), "ONE");
        adapter.addFragment(new SlideFragment(R.drawable.ic_sick_second), "TWO");
        adapter.addFragment(new SlideFragment(R.drawable.ic_gences), "ONE");
        adapter.addFragment(new SlideFragment(R.drawable.ic_corona), "TWO");
        adapter.addFragment(new SlideFragment(R.drawable.ic_sick_second), "ONE");
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
        mAdapter = new NewsViewAdapter(initializaFirstNewsItems(), this);
        mSecondListAdapter = new SecondNewsAdapter(initializaSecondNewsItems(),this);
        mThirdListAdapter = new NewsViewAdapter(initializaFirstNewsItems(), this);
        mFifthRecyclerAdapter=new SimpleLinkAdapter(initializaFirstNewsItems());
        initializeRecyclerView(view, firstRecyclerView, mAdapter);
        initializeRecyclerView(view, secondRecyclerView, mSecondListAdapter);
        initializeRecyclerView(view, thirdRecyclerView, mThirdListAdapter);
        initializeRecyclerView(view, fourthRecyclerView, mSecondListAdapter);
        initializeRecyclerViewVertical(view, fifthRecyclerView, mFifthRecyclerAdapter);
        timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimrTask(), 2000, 4000);
//        mfirstList.setOnClickListener(onClickListener());
//        mSecondList.setOnClickListener(onClickListener());
//        mThirdList.setOnClickListener(onClickListener());
//        mfourthList.setOnClickListener(onClickListener());
//        mfifthList.setOnClickListener(onClickListener());
        return view;
    }
    private View.OnClickListener onClickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).loadShowMoreFirstList(initializaSecondNewsItems());
            }
        };
    }


    private void initializeRecyclerView(View view, RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void initializeRecyclerViewVertical(View view, RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private List<NewsItem> initializaFirstNewsItems() {
        List<NewsItem> newsItems;
        newsItems = new ArrayList<>();
        newsItems.add(new NewsItem("رشد فیزیکی نوزاد در ماه های اول"
                , "اینکه در هر ماه از زندگی نوزاد، انتظار چه اندازه رشد از او داشته باشید، می\u200Cتواند تا حدود زیادی نگرانی\u200Cتان را درباره رشد فیزیکی مطلوب نوزاد برطرف کند. اگر از همین حالا می\u200Cخواهید بدانید چه زمان نوزادتان قرار است بنشیند، راه برود، واکنش داشته باشد، بهتر است این اینفوگرافی را از دست ندهید. ", R.drawable.ic_baby_grow, R.drawable.ic_baby_grow_banner));
        newsItems.add(new NewsItem("خطر کیک های آلوده به قرص های مشکوک"
                , "در حالی که مردم جنوب سیستان و بلوچستان همچنان درحال کشف کیک های بسته بندی شده آلوده به قرص هستند، سرپرست مرکز بهداشت چابهار مدعی شد، تمامی موارد مشکوک جمع\u200Cآوری شده و حتی برای رسیدگی به موضوع پرونده قضایی تشکیل شده است.", R.drawable.ic_food, R.drawable.ic_food_banner));
        newsItems.add(new NewsItem("تاثیر بی خوابی در رشد قد و وزن نوزادان"
                , "جنین در رحم مادر، شب و روز در خواب به سر می برد، زیرا کار و فعالیت ندارد و تمام نیروی او بایستی صرف سازندگی شود و از طرف دیگر سلول های جوان و ناکامل او قادر به ایجاد و نگه داری نیروی زیاد نیست . لذا ۲۴ ساعت می خوابد و احتیاجات خود را از سرمی گیرد . اطفال نارس هم به همین علت بایستی زیاد بخوابند.\n" +
                "\n" +
                "پس از تولد نیز نوزاد نیاز شدیدی به خواب و استراحت کامل دارد و در روزهای اول تولد باید معمولا ۲۰ تا ۲۴ ساعت در خواب باشد، یعنی در ۲۴ ساعت شبانه روز فقط هنگام شیر خوردن بیدار شود و باقی ساعات در خواب باشد تا برای سازندگی نیرو ذخیره کند. این برنامه حداقل تا انتهای ماه اول تولد و یا روز چهلم ادامه خواهد داشت و اگر برنامه ی نوزادی غیر از این باشد، ممکن است دچار مشکلی باشد.", R.drawable.ic_baby_weight, R.drawable.ic_baby_weight_banner));
        newsItems.add(new NewsItem("دیابت در ماه های اخر بارداری چه علاِئمی دارد",
                "ابتلا به دیابت بارداری به این معنا نیست که شما قبل از بارداری دیابت داشته\u200Cاید یا بعد از زایمان هم دچار دیابت خواهید شد. با این\u200C حال دچار شدن به دیابت بارداری احتمال ابتلای شما را به دیابت نوع ۲ افزایش خواهد داد.\n" +
                        "\n" +
                        "علاوه\u200Cبراین با مراقبت نادرست، خطر ابتلای کودک\u200Cتان به دیابت افزایش می\u200Cیابد و در طول بارداری و زایمان احتمال ایجاد خطراتی در شما و کودک\u200Cتان بیشتر می\u200Cشود.", R.drawable.ic_sick, R.drawable.ic_sick_banner));
        return newsItems;
    }

    private List<NewsItem> initializaSecondNewsItems() {
        List<NewsItem> newsItems;
        newsItems = new ArrayList<>();
        newsItems.add(new NewsItem("دلایل اضافه \u200Cوزن یا وزن\u200Cگیری بیش از حد"
                , "اضافه وزن پیش از \u200Cبارداری یا وزن\u200Cگیری بیش از اندازۀ مادر در دوران بارداری ممکن است باعث بروز مشکلاتی در بارداری شود. از آنجا که کاهش وزن در دوران بارداری خطرناک است، بهتر است برای کنترل وزن\u200Cگیری خود در دوران بارداری با پزشکتان مشورت کنید. در این مطلب می\u200Cتوانید با مشکلات ناشی از اضافه \u200Cوزن در بارداری و همچنین راه\u200Cهای کنترل آن آشنا شوید.", R.drawable.ic_sick_second, R.drawable.ic_sick_second));
        newsItems.add(new NewsItem("دفعات شیردهی روزانه به نوزاد"
                , "اولین باری که نوزاد خود را در اتاق زایمان در آغوش می\u200Cگیرید، زمان بسیار خوبی برای شروع اولین شیردهی است. در آغاز، بدن شما مقادیر کمی از شیر خاصی به نام آغوز تولید می\u200Cکند که به محافظت از کودک در برابر عفونت کمک خواهد کرد. معدۀ نوزاد شما بسیار کوچک است، بنابراین او تنها به همین مقادیر کوچک برای سیر شدن نیاز دارد. با بزرگ شدن معدۀ او، نوع شیر شما تغییر خواهد کرد و میزان بیشتری شیر در سینۀ شما تولید می\u200Cشود. در این مطلب می\u200Cتوانید با شروع شیردهی، دفعات شیردهی روزانه به نوزاد، یافتن یک روش و وضعیت شیردهی مناسب، تغذیۀ مادران شیرده و مشکلات احتمالی در دوران شیردهی آشنا شوید.", R.drawable.ic_baby_food, R.drawable.ic_baby_food));
        newsItems.add(new NewsItem("آیا باید از کرونا ترسید؟"
                , "تا پایان قرن بیستم و سال ۲۰۰۰، باور بر این بود که ویروس\u200Cهای کرونا جزو عوامل بیماری\u200Cزای ویروسی هستند و از جمله شایع\u200Cترین علل سرماخوردگی به حساب می\u200Cآمدند. سال ۲۰۰۳ بود که در چین یک عفونت شدید تنفسی ویروسی در زمینه کرونا ویروس به نام سارس ظهور کرد و در زمان کوتاهی ۲۷ کشور درگیر آن شدند، آن زمان این ویروس ۸۰۰ نفر را به کام مرگ کشاند. با این حال بعد از مدتی با اقدامات بین\u200Cالمللی این بیماری تحت کنترل درآمد.  \n" +
                "\n" +
                "پس از آن، حدود ۶ سال پیش بود که موارد جدیدی از کرونا ویروس یا عفونت شدید تنفسی در کشور عربستان، امارات متحده عربی، عمان و کشورهای حاشیه جنوبی خلیج فارس مشاهده شد. این بار افرادی که از شترها مراقبت می\u200Cکردند، در تماس با شتر به نوعی از این ویروس مبتلا شدند. این ویروس به ویروس مرس یا خاورمیانه شهرت یافت. بعدها وزارت بهداشت کشور ما از شناسایی دو مورد ابتلا به کرونا ویروس مرس در استان کرمان خبر دارد که به گفته مقامات مسئول وزارت بهداشت، با تشخیص به موقع و تحت کنترل درآمدن بیماری از گسترش و استقرار آن در کشور جلوگیری شد.", R.drawable.ic_corona, R.drawable.ic_corona));
        newsItems.add(new NewsItem("شایع ترین اختلالات ژنتیکی در کودکان را بشناسید",
                "یک اختلال ژنتیکی از طریق ایجاد ناهنجاری هایی که در فاکتورها و عناصر تعیین کننده صفات و ویژگی های ژنتیکی فرد شامل مولکول های دی ان ای یا ژنوم (توالی ژن ها) ظاهر می شود و این ناهنجاری ها به چهار گروه جهش تک ژنی، چندژنی، تغییرات کروموزمی و میتوکندریال تقسیم بندی می شوند. همچنین بر محققان مشخص است که برخی نژادها مستعد ابتلا به اختلال های ژنتیکی خاص هستند به گونه ای که ابتلای آنان به این بیماری ها از پیش تعیین شده است. به طور مثال ساکنان منطق مدیترانه ای اروپا بیشتر مستعد ابتلا به نوع کم خونی ژنتیکی هستند و برخی اختلال های ژنتیکی همچون کم خونی داسی شکل، حاصل واکنش بدن برای مقابله با محرک های محیط زیست است. ", R.drawable.ic_gences, R.drawable.ic_gences));
        return newsItems;

    }

//    private List<NewsItem> initializaThirdNewsItems() {
//        List<NewsItem> newsItems;
//        newsItems = new ArrayList<>();
//        newsItems.add(new NewsItem("تاثیر بی خوابی در رشد قد و وزن نوزادان"
//                , "نظرات(17)", R.drawable.ic_baby_weight));
//        newsItems.add(new NewsItem("دیابت در ماه های اخر بارداری چه علاِئمی دارد",
//                "نظرات(10)", R.drawable.ic_sick));
//        newsItems.add(new NewsItem("رشد فیزیکی نوزاد در ماه های اول"
//                , "نظرات(12)", R.drawable.ic_baby_grow));
//        newsItems.add(new NewsItem("خطر کیک های آلوده به قرص های مشکوک"
//                , "نظرات(5)", R.drawable.ic_food));
//        return newsItems;
//
//    }

    @Override
    public void onItemClick(int groupID, int id) {
        if (groupID == 0)
            ((MainActivity) getActivity()).loadShowNewsDetail(initializaFirstNewsItems().get(id));
        if (groupID == 1)
            ((MainActivity) getActivity()).loadShowNewsDetail(initializaSecondNewsItems().get(id));
        //Toast.makeText(getActivity().getApplicationContext(),String.valueOf(id),Toast.LENGTH_SHORT).show();
    }

    public class MyTimrTask extends TimerTask {

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //  Toast.makeText(getActivity(), "guyguy", Toast.LENGTH_LONG).show();
                    if (pager.getCurrentItem() == slides.size() - 1) {
                        pager.setCurrentItem(0);
                    } else {
                        pager.setCurrentItem(pager.getCurrentItem() + 1);
                    }
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

    @Override
    public void onPause() {
        timer.cancel();
        super.onPause();
    }

}
