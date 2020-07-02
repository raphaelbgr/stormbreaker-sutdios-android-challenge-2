package com.stormbreakerstudios.android.challenge;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Integer> items = Arrays.asList(0, 1, 2, 3);
    List<Integer> itemTypes = Arrays.asList(99, 199, 299, 399);

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ArticleOfTheDayViewHolder) {
            ((ArticleOfTheDayViewHolder) holder).bind();
        }
        if (holder instanceof FeaturedArticles) {
            ((RecyclerView) holder.itemView.findViewById(R.id.rv_article_showcase)).setAdapter(
                    new ShowcaseAdapter(
                            Arrays.asList(
                                    new ShowcaseFakeData("Lotus Focus", R.drawable.lotus),
                                    new ShowcaseFakeData("Peaceful thoughts: How to", R.drawable.peaceful_thoughts),
                                    new ShowcaseFakeData("Sand", R.drawable.sand)
                            )
                    )
            );
            ((TextView) holder.itemView.findViewById(R.id.tv_title)).setText("Featured Articles");
        }
        if (holder instanceof TopicsArticles) {
            ((RecyclerView) holder.itemView.findViewById(R.id.rv_article_showcase)).setAdapter(
                    new ShowcaseAdapter(
                            Arrays.asList(
                                    new ShowcaseFakeData("Peace", R.drawable.peace),
                                    new ShowcaseFakeData("Balance", R.drawable.stonestack),
                                    new ShowcaseFakeData("Night", R.drawable.night)
                            )
                    )
            );
            ((TextView) holder.itemView.findViewById(R.id.tv_title)).setText("Topics");
        }
        if (holder instanceof TimeToReadArticles) {
            ((RecyclerView) holder.itemView.findViewById(R.id.rv_article_showcase)).setAdapter(
                    new ShowcaseAdapter(
                            Arrays.asList(
                                    new ShowcaseFakeData("5 min", R.drawable.couch),
                                    new ShowcaseFakeData("10 min", R.drawable.blonde),
                                    new ShowcaseFakeData("20 min", R.drawable.flower)
                            )
                    )
            );
            ((TextView) holder.itemView.findViewById(R.id.tv_title)).setText("Time to Read");
        }
    }

    @Override
    public int getItemViewType(int position) {
        return itemTypes.get(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 99: {
                return new ArticleOfTheDayViewHolder(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.article_of_the_day_vh, parent, false)
                );
            }
            case 199: {
                return new FeaturedArticles(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.article_showcase_vh, parent, false)
                );
            }
            case 299: {
                return new TopicsArticles(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.article_showcase_vh, parent, false)
                );
            }
            default: {
                return new TimeToReadArticles(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.article_showcase_vh, parent, false)
                );
            }
        }
    }

    static class ShowcaseFakeData {
        String text;
        int img;

        public ShowcaseFakeData(String text, int img) {
            this.text = text;
            this.img = img;
        }
    }

    static class ArticleOfTheDayViewHolder extends RecyclerView.ViewHolder {
        public ArticleOfTheDayViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind() {
            Picasso.get()
                    .load(R.drawable.article_of_day)
                    .fit()
                    .into((ImageView) itemView.findViewById(R.id.iv_article_of_the_day));
        }
    }

    static class FeaturedArticles extends RecyclerView.ViewHolder {
        public FeaturedArticles(@NonNull View itemView) {
            super(itemView);
        }
    }

    static class TopicsArticles extends RecyclerView.ViewHolder {

        public TopicsArticles(@NonNull View itemView) {
            super(itemView);
        }
    }

    static class TimeToReadArticles extends RecyclerView.ViewHolder {

        public TimeToReadArticles(@NonNull View itemView) {
            super(itemView);
        }
    }

    static class ShowcaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<ShowcaseFakeData> showcaseFakeData;
        private List<Integer> items = Arrays.asList(0, 1, 3);

        public ShowcaseAdapter(List<ShowcaseFakeData> showcaseFakeData) {
            this.showcaseFakeData = showcaseFakeData;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ArticleViewHolder(
                    LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.image_vh, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            switch (position) {
                case 0: {
                    Picasso.get().load(showcaseFakeData.get(position).img).fit().into((ImageView) holder.itemView.findViewById(R.id.iv_article));
                    ((TextView) holder.itemView.findViewById(R.id.tv_article_title)).setText(showcaseFakeData.get(position).text);
                }
                case 1: {
                    Picasso.get().load(showcaseFakeData.get(position).img).fit().into((ImageView) holder.itemView.findViewById(R.id.iv_article));
                    ((TextView) holder.itemView.findViewById(R.id.tv_article_title)).setText(showcaseFakeData.get(position).text);
                }
                case 2: {
                    Picasso.get().load(showcaseFakeData.get(position).img).fit().into((ImageView) holder.itemView.findViewById(R.id.iv_article));
                    ((TextView) holder.itemView.findViewById(R.id.tv_article_title)).setText(showcaseFakeData.get(position).text);
                }
            }
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        static class ArticleViewHolder extends RecyclerView.ViewHolder {

            public ArticleViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
