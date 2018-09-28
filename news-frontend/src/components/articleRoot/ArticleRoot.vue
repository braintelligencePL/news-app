<template>
    <div class="album py-5 bg-light">

        <div>
            Wybierz kategorię:
            <select v-model="selectedCategory">
                <option>technology</option>
                <option>business</option>
                <option>entertainment</option>
                <option>general</option>
                <option>health</option>
                <option>science</option>
                <option>sports</option>
            </select>
        </div>

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
                selectedCategory: this.selectedCategory || "technology",
                queryText: ''
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

<style scoped>
    .custom-input {
        margin-left: 50px;
        width: 300px;
    }
</style>