package com.rxjava2.android.samples.ui.pagination;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.rxjava2.android.samples.R;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;

/**
 * Created by amitshekhar on 15/03/17.
 * 分页加载的示例
 */

public class PaginationActivity extends AppCompatActivity {

    public static final String TAG = PaginationActivity.class.getSimpleName();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();// 一次性物品容器
    private PublishProcessor<Integer> paginator = PublishProcessor.create(); //一个事件水管（事件处理器）
    private PaginationAdapter paginationAdapter;// 列表的adapter
    private RecyclerView recyclerView; //列表
    private ProgressBar progressBar;    //加载进度条
    private boolean loading = false;    //是否正在加载
    private int pageNumber = 1; // 当前页面
    private final int VISIBLE_THRESHOLD = 1;    //保留的最少可见item，也就是说还有一个数据没加载出来的时候就可以出发刷新
    private int lastVisibleItem, totalItemCount; //最后一条可见数据，总共的数据数
    private LinearLayoutManager layoutManager;  // 列表的布局管理器


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagination);
//        初始化控件
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        paginationAdapter = new PaginationAdapter();
        recyclerView.setAdapter(paginationAdapter);


        setUpLoadMoreListener();
        subscribeForData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear(); //清空一次性用品容器，并把所有的绑定事件解除
    }

    /**
     * setting listener to get callback for load more
     * 设置刷新的触发
     */
    private void setUpLoadMoreListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView,
                                   int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = layoutManager.getItemCount();
                lastVisibleItem = layoutManager
                        .findLastVisibleItemPosition();
                if (!loading
                        && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {//触发加载更多的条件
                    pageNumber++; //增加页数
                    paginator.onNext(pageNumber); //水管发送事件，事件内容为：需要请求的数据的页数为第pageNumber页
                    loading = true;         //修改状态为加载中
                }
            }
        });
    }

    /**
     * subscribing for data
     * 订阅
     */
    private void subscribeForData() {

        Disposable disposable = paginator
                .onBackpressureDrop()//扔掉多余事件
                .concatMap(new Function<Integer, Publisher<List<String>>>() {
                    @Override
                    public Publisher<List<String>> apply(@NonNull Integer page) throws Exception {
                        loading = true; //修改当前加载状态为true
                        progressBar.setVisibility(View.VISIBLE);//显示进度条
                        return dataFromNetwork(page); //模拟网络请求
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()) //设置观察者的事件处理线程在主线程
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(@NonNull List<String> items) throws Exception { //观察者处理事件
                        paginationAdapter.addItems(items);  //加载数据
                        paginationAdapter.notifyDataSetChanged();
                        loading = false; //修改下载状态为false，就又可以进行加载了
                        progressBar.setVisibility(View.INVISIBLE);//隐藏加载更多的进度条
                    }
                });

        compositeDisposable.add(disposable); //将disposable加入容器

        paginator.onNext(pageNumber);// 加载第一页内容先

    }

    /**
     * Simulation of network data
     * 模拟网络请求
     */
    private Flowable<List<String>> dataFromNetwork(final int page) {
        return Flowable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map(new Function<Boolean, List<String>>() {
                    @Override
                    public List<String> apply(@NonNull Boolean value) throws Exception {
                        List<String> items = new ArrayList<>();
                        for (int i = 1; i <= 10; i++) {
                            items.add("Item " + (page * 10 + i));
                        }
                        return items;
                    }
                });
    }
}
