<template>
  <router-view/>
</template>

<script lang="ts" setup>
  console.log()

</script>

<style lang="scss">
  .router-link-active {
    color: $color-main!important;
    border-bottom: 2px solid $color-main;
  }
  .header {
    position: fixed;
    height: 120px;
    padding: 20px 80px;
    box-sizing: border-box;
    background-image: radial-gradient(transparent 1px, #fff 1px);
    background-size: 1px 1px;
    backdrop-filter: saturate(50%) blur(4px);
    border-bottom: 1px solid #ccc;
    z-index: 999;
    .logo {
      img {
        height: 70px;
      }
    }
    .navbar {
      a {
        padding: 20px 0;
        width: 80px;
        text-align: center;
        color: #000;
        &:hover {
          @extend .router-link-active;
        }
      }
    }
  }

  /*滚动动画相关*/
  .default-animate {
    opacity: 0;
    filter: blur(5px);
    transition: all 1s;
    transform: translateX(100%);
  }
  .scroll-animate {
    opacity: 1;
    filter: blur(0);
    transform: translateX(0);
  }
</style>
