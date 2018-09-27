<template>
    <div class="col-md-4">
        <div class="card mb-4 shadow-sm">
            <img class="card-img-top" v-bind:src="imageUrl">
            <div class="card-body accordion">

                <div class="my-3 py-3">
                    <h2 class="display-5">{{title}}</h2>
                </div>

                <p class="card-text">{{description}}}</p>
                <a class="btn btn-sm btn-outline-secondary" v-bind:href="articleUrl">Read Article</a>

                <br>
                <small class="text-muted">{{author}}</small>
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