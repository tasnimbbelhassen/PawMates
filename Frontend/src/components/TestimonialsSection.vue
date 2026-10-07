<template>
  <section class="testimonials">
    <div class="avatars-row">
      <div
        v-for="(t, i) in testimonials"
        :key="i"
        class="avatar-wrap"
        :class="{ active: current === i }"
        @click="current = i"
      >
        <img :src="t.avatar" :alt="t.name" />
      </div>
    </div>

    <div class="quote-wrap">
      <button class="nav-btn" @click="prev">‹</button>
      <div class="quote">
        <p class="quote-text">"{{ testimonials[current].text }}"</p>
        <p class="quote-author">{{ testimonials[current].name }}</p>
        <p class="quote-pet">{{ testimonials[current].pet }}</p>
      </div>
      <button class="nav-btn" @click="next">›</button>
    </div>

    <div class="dots">
      <span
        v-for="(_, i) in testimonials"
        :key="i"
        class="dot"
        :class="{ active: current === i }"
        @click="current = i"
      ></span>
    </div>
  </section>
</template>

<script setup>
import { ref } from 'vue'

const current = ref(1)

const testimonials = [
  {
    text: "Grâce à PawMates, j'ai trouvé Rex en moins d'une semaine. Le processus était simple et l'équipe du refuge était formidable.",
    name: 'Amina Trabelsi',
    pet: 'Berger allemand · 4 ans',
    avatar: 'https://images.unsplash.com/photo-1544723795-3fb6469f5b39?w=80&q=80',
  },
  {
    text: "PawMates a changé notre vie. Notre chat Luna s'est tout de suite intégrée à la famille comme si elle avait toujours été là.",
    name: 'Karim Benhamed',
    pet: 'Siamoise · 2 ans',
    avatar: 'https://images.unsplash.com/photo-1531427186611-ecfd6d936c79?w=80&q=80',
  },
  {
    text: "Une plateforme incroyable qui connecte vraiment les familles aux refuges. L'adoption de Milo a été un moment inoubliable.",
    name: 'Sara Mansouri',
    pet: 'Labrador · 3 ans',
    avatar: 'https://images.unsplash.com/photo-1508214751196-bcfd4ca60f91?w=80&q=80',
  },
]

const prev = () => {
  current.value = (current.value - 1 + testimonials.length) % testimonials.length
}
const next = () => {
  current.value = (current.value + 1) % testimonials.length
}
</script>

<style scoped>
.testimonials {
  background: #fff;
  padding: 5rem 5vw;
  text-align: center;
  border-top: 1px solid #eee;
}
.avatars-row {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 1rem;
  margin-bottom: 3rem;
}
.avatar-wrap {
  width: 56px;
  height: 56px;
  border-radius: 50%;
  overflow: hidden;
  border: 3px solid transparent;
  cursor: pointer;
  opacity: 0.5;
  transition: all 0.25s;
}
.avatar-wrap img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.avatar-wrap.active {
  opacity: 1;
  border-color: #7ecec4;
  transform: scale(1.15);
}

.quote-wrap {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 2rem;
  max-width: 700px;
  margin: 0 auto 2rem;
}
.nav-btn {
  background: transparent;
  border: 1.5px solid #ddd;
  color: #1a1a2e;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  font-size: 1.2rem;
  cursor: pointer;
  transition: all 0.2s;
  flex-shrink: 0;
}
.nav-btn:hover {
  border-color: #1a1a2e;
  background: #1a1a2e;
  color: #fff;
}
.quote {
  flex: 1;
}
.quote-text {
  font-family: 'Playfair Display', serif;
  font-size: clamp(1rem, 2vw, 1.25rem);
  color: #333;
  line-height: 1.7;
  margin-bottom: 1rem;
  font-style: italic;
}
.quote-author {
  font-weight: 600;
  color: #1a1a2e;
  font-size: 0.95rem;
}
.quote-pet {
  font-size: 0.8rem;
  color: #aaa;
  margin-top: 2px;
}

.dots {
  display: flex;
  justify-content: center;
  gap: 6px;
}
.dot {
  width: 8px;
  height: 8px;
  border-radius: 50%;
  background: #ddd;
  cursor: pointer;
  transition:
    background 0.2s,
    transform 0.2s;
}
.dot.active {
  background: #1a1a2e;
  transform: scale(1.3);
}
</style>
