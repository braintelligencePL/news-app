<template>
    <div class="col-md-4">
        <div class="card mb-4 shadow-sm box-shadow">

            <div v-if="imageUrl.includes('http')">
                <img class="card-img-top" v-bind:src="imageUrl" width="20" height="200px">
            </div>
            <div v-else>
                <img class="card-img-top" alt="default image" src="../../assets/placeholder.png" width="20" height="200px">
            </div>

            <div class="card-body accordion">
                <h4 class="display-5"><a v-bind:href="articleUrl">{{title}}</a></h4>

                <p class="card-text">{{description}}</p><br>

            </div>
            <div class="card-footer">

                <div>{{sourceName}}</div>
                <div v-if="author.includes('http')">
                    <small><a v-bind:href="author">{{author}}</a></small>
                </div>
                <div v-else>
                    <small>{{author}}</small>
                </div>

            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Article',
        props: {
            title: String,
            author: String,
            description: String,
            date: String,
            sourceName: String,
            articleUrl: String,
            imageUrl: String
        }
    }
</script>

<style scoped>
    .box-shadow {
        display: block;
        margin: 10px auto 25px;
        border-radius: 2%;
        box-shadow: 0px 7px 10px 0px;
    }
</style>