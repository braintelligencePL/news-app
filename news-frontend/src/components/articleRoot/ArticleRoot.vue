<template>
    <div class="album py-5 bg-light">

        <select v-model="selectedCategory">
            <option disabled value="">Please select one</option>
            <option>technology</option>
            <option>business</option>
        </select>
        <span>Selected: {{ selectedCategory }}</span>


        <br>
        <div class="container">
            <div class="row">
                <Article
                        v-for="article in articles"
                        v-bind="article"
                        v-bind:key="article.articleUrl">
                </Article>
            </div>
        </div>
    </div>
</template>

<script>
    import {fetchArticles} from "../../api/api";
    import Article from "../article/Article";

    export default {
        name: 'ArticleRoot',
        components: {Article},
        data() {
            return {
                articles: [],
                selectedCategory: this.selectedCategory || "technology"
            }
        },

        watch: {
            'selectedCategory': function (newVal) {
                fetchArticles(newVal).then(res => {
                    this.articles = res.articles;
                });
            }
        },

        mounted() {
            fetchArticles("technology")
                .then(res => {
                    this.articles = res.articles;
                });
        },
        props: {}
    }
</script>