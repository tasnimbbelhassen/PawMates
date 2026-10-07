<template>
  <div class="page">
    <NavBar />

    <div class="app-layout">
      <!-- ═══ LEFT SIDEBAR ═══ -->
      <nav class="sidebar">
        <div class="sidebar-inner">
          <button 
            class="nav-item"
            :class="{ active: activeMenu === 'accueil' }"
            @click="activeMenu = 'accueil'; filter = 'all'; resetFilters()"
          >
            <svg viewBox="0 0 24 24">
              <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z" />
              <polyline points="9 22 9 12 15 12 15 22" />
            </svg>
            <span>Accueil</span>
          </button>
          
          <button 
            class="nav-item"
            :class="{ active: activeMenu === 'explorer' }"
            @click="activeMenu = 'explorer'"
          >
            <svg viewBox="0 0 24 24">
              <circle cx="11" cy="11" r="8" />
              <line x1="21" y1="21" x2="16.65" y2="16.65" />
            </svg>
            <span>Explorer</span>
          </button>
          
          <button
            class="nav-item"
            :class="{ active: filter === 'adoption' }"
            @click="filter = 'adoption'; activeMenu = 'accueil'"
          >
            <svg viewBox="0 0 24 24">
              <path
                d="M20.84 4.61a5.5 5.5 0 0 0-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 0 0-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 0 0 0-7.78z"
              />
            </svg>
            <span>Adoptions</span>
          </button>
          
          <button
            class="nav-item"
            :class="{ active: filter === 'donation' }"
            @click="filter = 'donation'; activeMenu = 'accueil'"
          >
            <svg viewBox="0 0 24 24">
              <polyline points="20 12 20 22 4 22 4 12" />
              <rect x="2" y="7" width="20" height="5" />
              <path d="M12 22V7" />
              <path d="M12 7H7.5a2.5 2.5 0 0 1 0-5C11 2 12 7 12 7z" />
              <path d="M12 7h4.5a2.5 2.5 0 0 0 0-5C13 2 12 7 12 7z" />
            </svg>
            <span>Dons</span>
          </button>

          <div class="sidebar-sep"></div>

          <!-- Barre de recherche dans Explorer -->
          <div v-if="activeMenu === 'explorer'" class="explorer-search">
            <div class="explorer-search-bar">
              <svg class="search-icon-small" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                <circle cx="10" cy="10" r="7" />
                <line x1="15" y1="15" x2="21" y2="21" />
              </svg>
              <input
                v-model="searchQuery"
                type="text"
                placeholder="Rechercher par titre, description..."
                @input="onSearchInput"
              />
              <button v-if="searchQuery" class="clear-search-small" @click="clearSearch">✕</button>
            </div>
          </div>

          <button class="post-btn" @click="requireAuth(() => router.push('/posts/create'))">
            <svg viewBox="0 0 24 24">
              <line x1="12" y1="5" x2="12" y2="19" />
              <line x1="5" y1="12" x2="19" y2="12" />
            </svg>
            <span>Publier un animal</span>
          </button>
        </div>
      </nav>

      <!-- ═══ FEED ═══ -->
      <main class="feed">
        <!-- Bannière publique -->
        <div v-if="!isLoggedIn && showBanner" class="public-banner">
          <span class="banner-paw">🐾</span>
          <div class="banner-text">
            <strong>Bienvenue sur PawMates !</strong>
            Rejoins la communauté pour adopter, donner, et aider les animaux à trouver un foyer.
          </div>
          <button class="banner-btn" @click="router.push('/register')">Rejoindre</button>
          <button class="banner-close" @click="showBanner = false">✕</button>
        </div>

        <!-- Résultats de recherche -->
        <div v-if="activeMenu === 'explorer' && searchQuery" class="search-info">
          <span>🔍 Résultats pour : "{{ searchQuery }}"</span>
          <span class="search-count">{{ filteredPosts.length }} résultat(s)</span>
        </div>

        <!-- Loading -->
        <div v-if="loading" class="loading-state">
          <div class="loading-card" v-for="n in 3" :key="n">
            <div class="skel skel-header"></div>
            <div class="skel skel-img"></div>
            <div class="skel skel-text"></div>
            <div class="skel skel-text short"></div>
          </div>
        </div>

        <!-- Error -->
        <div v-else-if="error" class="alert-error">{{ error }}</div>

        <!-- Empty -->
        <div v-else-if="filteredPosts.length === 0" class="empty-state">
          <span class="empty-icon">🐾</span>
          <p>Aucun animal ne correspond à vos critères.</p>
        </div>

        <!-- Posts -->
        <template v-else>
          <article
            v-for="post in paginatedPosts"
            :key="post.id"
            class="post-card"
          >
            <!-- Post header -->
            <div class="post-header" @click="router.push(`/posts/${post.id}`)">
              <div class="avatar">
                <img v-if="post.userAvatar" :src="post.userAvatar" :alt="post.userName" />
                <span v-else>
                  {{ (post.userName || 'U').charAt(0).toUpperCase() }}
                </span>
              </div>
              <div class="post-meta">
                <div class="post-author">{{ post.userName || 'Utilisateur' }}</div>
                <div class="post-location">
                  <svg viewBox="0 0 24 24">
                    <path d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0 1 18 0z" />
                    <circle cx="12" cy="10" r="3" />
                  </svg>
                  {{ post.city?.replace('_', ' ') || 'Tunisie' }}
                </div>
              </div>
              <div class="post-more" @click.stop>
                <svg viewBox="0 0 24 24">
                  <circle cx="12" cy="5" r="1" />
                  <circle cx="12" cy="12" r="1" />
                  <circle cx="12" cy="19" r="1" />
                </svg>
              </div>
            </div>

            <!-- Image -->
            <div class="post-image" @click="router.push(`/posts/${post.id}`)">
              <img v-if="post.image" :src="post.image" :alt="post.title" />
              <div v-else class="post-image-placeholder">🐾</div>
              
              <span v-if="post.is_adoption && post.is_donation" class="post-badge badge-both">
                🐾 Adoption & Don
              </span>
              <span v-else-if="post.is_adoption" class="post-badge badge-both">
                Adoption
              </span>
              <span v-else-if="post.is_donation" class="post-badge badge-both">
                Don
              </span>
            </div>

            <!-- Actions -->
            <div class="post-actions" @click.stop>
              <button
                class="icon-btn"
                :class="{ liked: likedPosts.has(post.id) }"
                @click="requireAuth(() => toggleLike(post.id))"
                aria-label="J'aime"
              >
                <svg viewBox="0 0 24 24">
                  <path
                    d="M20.84 4.61a5.5 5.5 0 0 0-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 0 0-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 0 0 0-7.78z"
                  />
                </svg>
              </button>
              <button 
                class="icon-btn" 
                aria-label="Commenter" 
                @click.stop="toggleComments(post.id)"
              >
                <svg viewBox="0 0 24 24">
                  <path d="M21 15a2 2 0 0 1-2 2H7l-4 4V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2z" />
                </svg>
              </button>
              <button
                class="icon-btn action-save"
                aria-label="Sauvegarder"
                @click.stop="requireAuth()"
              >
                <svg viewBox="0 0 24 24">
                  <path d="M19 21l-7-5-7 5V5a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2z" />
                </svg>
              </button>
            </div>

            <!-- Content -->
            <div class="post-caption" @click="router.push(`/posts/${post.id}`)">
              <span class="caption-name">{{ post.userName || 'Utilisateur' }}</span>
              {{ post.title }}
            </div>
            <div class="post-desc" @click="router.push(`/posts/${post.id}`)">
              {{ post.description?.substring(0, 100) }}...
            </div>
            <div class="post-hashtags" @click="router.push(`/posts/${post.id}`)">
              #{{ post.category }} #pawmates #tunisie
            </div>
            <div class="post-time" @click="router.push(`/posts/${post.id}`)">
              {{ formatDate(post.createdAt) }}
            </div>

            <!-- Indicateur de nombre de commentaires -->
            <div v-if="commentsData[post.id]?.length > 0 && !showComments[post.id]" 
                 class="comments-preview" 
                 @click.stop="toggleComments(post.id)">
              <span>💬 Voir les {{ commentsData[post.id].length }} commentaire{{ commentsData[post.id].length > 1 ? 's' : '' }}</span>
            </div>

            <!-- Section Commentaires -->
            <div v-if="showComments[post.id]" class="comments-section-feed" @click.stop>
              <div class="comments-list-feed">
                <div v-for="comment in (commentsData[post.id] || [])" :key="comment.id" class="comment-item-feed">
                  <div class="comment-avatar-feed">
                    {{ comment.user?.name?.[0]?.toUpperCase() || '🐾' }}
                  </div>
                  <div class="comment-bubble-feed">
                    <div class="comment-header-feed">
                      <span class="comment-author-feed">{{ comment.user?.name || 'Utilisateur' }}</span>
                      <span class="comment-date-feed">{{ formatDateComment(comment.created_at) }}</span>
                    </div>
                    <p class="comment-text-feed">{{ comment.content }}</p>
                  </div>
                </div>
                <div v-if="(!commentsData[post.id] || commentsData[post.id].length === 0) && showComments[post.id]" class="no-comments-feed">
                  <span>🐾</span>
                  <p>Soyez le premier à commenter !</p>
                </div>
              </div>
              
              <!-- Input de commentaire -->
              <div class="comment-input-feed">
                <div class="comment-avatar-feed small">
                  {{ authStore.user?.name?.[0]?.toUpperCase() || '🐾' }}
                </div>
                <input 
                  v-model="newComments[post.id]" 
                  type="text" 
                  placeholder="Ajouter un commentaire..."
                  @keyup.enter="submitComment(post.id)"
                  :disabled="!isLoggedIn"
                  @focus="!isLoggedIn && (showAuthModal = true)"
                />
                <button 
                  @click="submitComment(post.id)" 
                  :disabled="!newComments[post.id]?.trim()"
                  class="comment-send-btn"
                >
                  Envoyer
                </button>
              </div>
            </div>
          </article>
        </template>

        <!-- Pagination -->
        <div v-if="filteredPosts.length > postsPerPage" class="pagination">
          <button 
            @click="currentPage--" 
            :disabled="currentPage === 1"
            class="page-btn"
          >← Précédent</button>
          <span class="page-info">Page {{ currentPage }} sur {{ totalPages }}</span>
          <button 
            @click="currentPage++" 
            :disabled="currentPage === totalPages"
            class="page-btn"
          >Suivant →</button>
        </div>
      </main>

      <!-- ═══ RIGHT SIDEBAR ═══ -->
      <aside class="right-sidebar">
        <div v-if="isLoggedIn" class="profile-mini">
          <div class="guest-title">Bon retour !</div>
          <div class="guest-sub">Merci de vous être connecté</div>
          <div class="sidebar-sep"></div>
        </div>
        <div v-else class="guest-cta">
          <div class="guest-title">Rejoins PawMates</div>
          <div class="guest-sub">Adopte, donne, et aide les animaux en Tunisie.</div>
          <button class="cta-btn primary" @click="router.push('/register')">Créer un compte</button>
          <button class="cta-btn" @click="router.push('/login')">Se connecter</button>
        </div>

        <div class="right-section" v-if="isLoggedIn">
          <div class="section-title">Les publications </div>
          <div class="stats-grid">
            <div class="stat-box">
              <div class="stat-num">{{ allPosts.length }}</div>
              <div class="stat-lbl">Posts</div>
            </div>
          </div>
        </div>

        <div class="right-section">
          <div class="section-title">Filtrer par type</div>
          <div class="filter-btns">
            <button
              v-for="f in filterOptions"
              :key="f.value"
              class="filter-pill"
              :class="{ active: filter === f.value }"
              @click="filter = f.value"
            >
              {{ f.label }}
            </button>
          </div>
        </div>

        <!-- Filtres avancés (ville, catégorie, tri) -->
        <div class="right-section">
          <div class="section-title"> Ville</div>
          <div class="filter-scroll">
            <button
              v-for="city in cities"
              :key="city"
              class="filter-chip"
              :class="{ active: cityFilter === city }"
              @click="cityFilter = cityFilter === city ? '' : city"
            >
              {{ city.replace('_', ' ') }}
            </button>
          </div>
        </div>

        <div class="right-section">
          <div class="section-title">Catégorie</div>
          <div class="filter-scroll">
            <button
              v-for="cat in availableCategories"
              :key="cat"
              class="filter-chip"
              :class="{ active: categoryFilter === cat }"
              @click="categoryFilter = categoryFilter === cat ? '' : cat"
            >
              {{ cat }}
            </button>
          </div>
        </div>

        <div class="right-section">
          <div class="section-title">Trier par</div>
          <div class="sort-btns">
            <button
              class="sort-chip"
              :class="{ active: sortFilter === 'latest' }"
              @click="sortFilter = 'latest'"
            >
              Plus récent
            </button>
            <button
              class="sort-chip"
              :class="{ active: sortFilter === 'oldest' }"
              @click="sortFilter = 'oldest'"
            >
              Plus ancien
            </button>
            <button
              class="sort-chip"
              :class="{ active: sortFilter === 'title_asc' }"
              @click="sortFilter = 'title_asc'"
            >
              Titre A→Z
            </button>
            <button
              class="sort-chip"
              :class="{ active: sortFilter === 'title_desc' }"
              @click="sortFilter = 'title_desc'"
            >
              Titre Z→A
            </button>
          </div>
        </div>

        <div class="right-section">
          <div class="section-title">Tendances</div>
          <div class="tag-pills">
            <span class="pill">#adoption</span>
            <span class="pill">#chien</span>
            <span class="pill">#chat</span>
            <span class="pill">#tunisie</span>
            <span class="pill">#pawmates</span>
            <span class="pill">#don</span>
            <span class="pill">#refuge</span>
          </div>
        </div>

        <div class="footer-links">
          À propos · Aide · Confidentialité · Conditions<br />
          © 2026 PawMates
        </div>
      </aside>
    </div>

    <!-- ═══ MODALE AUTH ═══ -->
    <div v-if="showAuthModal" class="modal-overlay" @click.self="showAuthModal = false">
      <div class="auth-modal">
        <button class="modal-x" @click="showAuthModal = false">✕</button>
        <div class="auth-modal-paw">🐾</div>
        <h2 class="auth-modal-title">Rejoins PawMates</h2>
        <p class="auth-modal-sub">
          Connecte-toi pour liker, commenter et aider les animaux à trouver un foyer.
        </p>
        <button class="auth-btn primary" @click="router.push('/login')">Se connecter</button>
        <button class="auth-btn" @click="router.push('/register')">Créer un compte</button>
        <button class="auth-skip" @click="showAuthModal = false">
          Continuer en tant que visiteur
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted, watch } from 'vue'
import { useRouter } from 'vue-router'
import { postsAPI, commentsAPI } from '../services/api'
import { useAuthStore } from '../stores/authStore'
import NavBar from '../components/NavBar.vue'

const router = useRouter()
const allPosts = ref([])
const loading = ref(false)
const error = ref('')
const filter = ref('all')
const likedPosts = ref(new Set())
const activeMenu = ref('accueil')

// ── Recherche & filtres ───────────────────────────────────────────
const searchQuery = ref('')
const searchDebounce = ref(null)
const cityFilter = ref('')
const categoryFilter = ref('')
const sortFilter = ref('latest')

// Pagination
const currentPage = ref(1)
const postsPerPage = 10

const cities = [
  'Tunis', 'Sfax', 'Sousse', 'Kairouan', 'Bizerte', 'Gabes',
  'Ariana', 'Gafsa', 'Monastir', 'Ben_Arous', 'Kasserine',
  'Medenine', 'Nabeul', 'Tataouine', 'Beja', 'Jendouba',
  'El_Kef', 'Mahdia', 'Sidi_Bouzid', 'Siliana', 'Zaghouan',
  'Tozeur', 'Manouba', 'Kebili'
]

const availableCategories = computed(() => {
  const cats = new Set()
  allPosts.value.forEach(post => {
    if (post.category) cats.add(post.category)
  })
  return Array.from(cats).sort()
})

const hasActiveFilters = computed(() => {
  return searchQuery.value !== '' ||
    cityFilter.value !== '' ||
    categoryFilter.value !== ''
})

// Filtrage combiné (type depuis `filter` + recherche/ville/catégorie)
const filteredPosts = computed(() => {
  let result = [...allPosts.value]

  // Filtre par type (sidebar)
  if (filter.value === 'adoption') {
    result = result.filter(p => p.is_adoption === true || p.is_adoption === 1)
  } else if (filter.value === 'donation') {
    result = result.filter(p => p.is_donation === true || p.is_donation === 1)
  }

  // Recherche textuelle (seulement si en mode explorer ou si recherche active)
  if (searchQuery.value) {
    const q = searchQuery.value.toLowerCase()
    result = result.filter(p =>
      p.title?.toLowerCase().includes(q) ||
      p.description?.toLowerCase().includes(q) ||
      p.category?.toLowerCase().includes(q)
    )
  }

  // Filtre ville
  if (cityFilter.value) {
    result = result.filter(p => p.city === cityFilter.value)
  }

  // Filtre catégorie
  if (categoryFilter.value) {
    result = result.filter(p => p.category === categoryFilter.value)
  }

  // Tri
  switch (sortFilter.value) {
    case 'latest':
      result.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt))
      break
    case 'oldest':
      result.sort((a, b) => new Date(a.createdAt) - new Date(b.createdAt))
      break
    case 'title_asc':
      result.sort((a, b) => (a.title || '').localeCompare(b.title || ''))
      break
    case 'title_desc':
      result.sort((a, b) => (b.title || '').localeCompare(a.title || ''))
      break
  }

  return result
})

const paginatedPosts = computed(() => {
  const start = (currentPage.value - 1) * postsPerPage
  return filteredPosts.value.slice(start, start + postsPerPage)
})

const totalPages = computed(() =>
  Math.ceil(filteredPosts.value.length / postsPerPage) || 1
)

// Reset page quand les filtres changent
watch([filteredPosts], () => {
  if (currentPage.value > totalPages.value) currentPage.value = 1
})

const onSearchInput = () => {
  if (searchDebounce.value) clearTimeout(searchDebounce.value)
  searchDebounce.value = setTimeout(() => { 
    currentPage.value = 1 
  }, 300)
}

const clearSearch = () => {
  searchQuery.value = ''
  currentPage.value = 1
}

const resetFilters = () => {
  searchQuery.value = ''
  cityFilter.value = ''
  categoryFilter.value = ''
  sortFilter.value = 'latest'
  currentPage.value = 1
}

// ── Commentaires ──────────────────────────────────────────────────
const commentsData = ref({})
const newComments = ref({})
const showComments = ref({})

// ── Auth state ──────────────────────────────────────────────────
const authStore = useAuthStore()
const isLoggedIn = computed(() => authStore.isAuthenticated)

// ── UI state ────────────────────────────────────────────────────
const showAuthModal = ref(false)
const showBanner = ref(true)

const fetchComments = async (postId) => {
  try {
    const res = await commentsAPI.getByPost(postId)
    commentsData.value[postId] = res.data
  } catch (e) {
    console.error('Erreur chargement commentaires:', e)
    commentsData.value[postId] = []
  }
}

const submitComment = async (postId) => {
  const content = newComments.value[postId]
  if (!content?.trim()) return
  if (!isLoggedIn.value) { showAuthModal.value = true; return }
  try {
    const res = await commentsAPI.create({ postId: postId, content })
    if (!commentsData.value[postId]) commentsData.value[postId] = []
    commentsData.value[postId].unshift(res.data)
    newComments.value[postId] = ''
  } catch (e) {
    console.error('Erreur ajout commentaire:', e)
  }
}

const toggleComments = async (postId) => {
  if (showComments.value[postId]) {
    showComments.value[postId] = false
  } else {
    showComments.value[postId] = true
    if (!commentsData.value[postId]) await fetchComments(postId)
  }
}

const requireAuth = (action) => {
  if (!isLoggedIn.value) { showAuthModal.value = true; return false }
  action?.()
  return true
}

const filterOptions = [
  { value: 'all', label: 'Tous' },
  { value: 'adoption', label: 'Adoption' },
  { value: 'donation', label: 'Dons' },
]

const fetchPosts = async () => {
  loading.value = true
  error.value = ''
  try {
    const res = await postsAPI.getAll()
    allPosts.value = res.data.map(post => ({
      ...post,
      userName: post.user?.name || post.user_name || post.username || post.author || post.userName || 'Utilisateur',
      userAvatar: post.user?.avatar || post.user_avatar || post.avatar || null,
      is_adoption: post.is_adoption || post.isAdoption || false,
      is_donation: post.is_donation || post.isDonation || false,
      likesCount: post.likes_count || post.likesCount || 0,
      createdAt: post.created_at || post.createdAt
    }))
  } catch (e) {
    error.value = 'Erreur lors du chargement des posts'
    console.error(e)
  } finally {
    loading.value = false
  }
}

const toggleLike = (postId) => {
  const set = new Set(likedPosts.value)
  if (set.has(postId)) set.delete(postId)
  else set.add(postId)
  likedPosts.value = set
}

const formatDate = (date) => (date ? new Date(date).toLocaleDateString('fr-FR') : '')

const formatDateComment = (date) => {
  if (!date) return ''
  const now = new Date()
  const d = new Date(date)
  const diffMs = now - d
  const diffMins = Math.floor(diffMs / 60000)
  const diffHours = Math.floor(diffMs / 3600000)
  const diffDays = Math.floor(diffMs / 86400000)
  if (diffMins < 1) return 'À l\'instant'
  if (diffMins < 60) return `Il y a ${diffMins} min`
  if (diffHours < 24) return `Il y a ${diffHours} h`
  if (diffDays < 7) return `Il y a ${diffDays} j`
  return d.toLocaleDateString('fr-FR')
}

watch(filter, fetchPosts)
onMounted(fetchPosts)
</script>

<style scoped>
/* ─── FONTS ─── */
@import url('https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,500;1,400&family=DM+Sans:wght@400;500&display=swap');

/* ─── VARIABLES ─── */
:global(:root) {
  --navy: #1a1a2e;
  --gold: #c8a84b;
  --gold-light: #f5d96b;
  --white: #ffffff;
  --bg: #fafaf8;
  --border: #ede9e0;
  --muted: #888;
  --blue-tag: #2b7de9;
  --blue-bg: #e8f4ff;
  --orange-tag: #e07b2b;
  --orange-bg: #fff3e0;
  --radius: 10px;
  --radius-sm: 6px;
  --radius-full: 50px;
}

/* ─── PAGE SHELL ─── */
.page {
  min-height: 100vh;
  background: var(--bg);
  font-family: 'DM Sans', sans-serif;
}

/* ─── LAYOUT ─── */
.app-layout {
  display: grid;
  grid-template-columns: 240px 1fr 290px;
  max-width: 1100px;
  margin: 0 auto;
  min-height: calc(100vh - 60px);
}

/* ─── LEFT SIDEBAR ─── */
.sidebar {
  border-right: 1px solid var(--border);
  background: var(--white);
}
.sidebar-inner {
  position: sticky;
  top: 60px;
  height: calc(100vh - 60px);
  display: flex;
  flex-direction: column;
  padding: 1.5rem 1rem;
  gap: 2px;
  overflow-y: auto;
}

.nav-item {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 0.65rem 0.75rem;
  border-radius: var(--radius-sm);
  cursor: pointer;
  color: var(--muted);
  font-size: 14px;
  background: none;
  border: none;
  font-family: 'DM Sans', sans-serif;
  width: 100%;
  text-align: left;
  transition: background 0.15s, color 0.15s;
}
.nav-item svg {
  width: 22px;
  height: 22px;
  flex-shrink: 0;
  stroke: currentColor;
  fill: none;
  stroke-width: 1.8;
  stroke-linecap: round;
  stroke-linejoin: round;
}
.nav-item:hover,
.nav-item.active {
  background: var(--bg);
  color: var(--navy);
  font-weight: 500;
}

.sidebar-sep {
  height: 1px;
  background: var(--border);
  margin: 0.75rem 0;
}

.post-btn {
  margin-top: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;
  padding: 0.7rem 1rem;
  background: var(--navy);
  color: #fff;
  border-radius: var(--radius-sm);
  font-size: 14px;
  font-weight: 500;
  cursor: pointer;
  border: none;
  font-family: 'DM Sans', sans-serif;
  transition: background 0.2s, transform 0.15s;
}
.post-btn:hover {
  background: var(--gold);
  transform: translateY(-1px);
}
.post-btn svg {
  width: 18px;
  height: 18px;
  stroke: currentColor;
  fill: none;
  stroke-width: 2;
  stroke-linecap: round;
}

/* ─── RECHERCHE DANS EXPLORER (LEFT PANEL) ─── */
.explorer-search {
  margin: 0.5rem 0 0.5rem 0;
  padding: 0 0.5rem;
}

.explorer-search-bar {
  position: relative;
  width: 100%;
}

.search-icon-small {
  position: absolute;
  left: 0.75rem;
  top: 50%;
  transform: translateY(-50%);
  color: #aaa;
  pointer-events: none;
}

.explorer-search-bar input {
  width: 100%;
  padding: 0.5rem 2rem 0.5rem 2rem;
  border: 1.5px solid var(--border);
  border-radius: 30px;
  font-size: 0.8rem;
  font-family: inherit;
  outline: none;
  background: var(--bg);
  transition: all 0.2s;
}

.explorer-search-bar input:focus {
  border-color: var(--gold);
  background: var(--white);
}

.clear-search-small {
  position: absolute;
  right: 0.75rem;
  top: 50%;
  transform: translateY(-50%);
  background: none;
  border: none;
  color: #aaa;
  cursor: pointer;
  font-size: 0.8rem;
  padding: 2px 4px;
  line-height: 1;
}

.clear-search-small:hover {
  color: var(--navy);
}

/* ─── FEED ─── */
.feed {
  padding: 1.5rem;
  display: flex;
  flex-direction: column;
  gap: 1.25rem;
  background: var(--bg);
  border-right: 1px solid var(--border);
}

/* ─── BANNIÈRE PUBLIQUE ─── */
.public-banner {
  display: flex;
  align-items: center;
  gap: 12px;
  background: #fff9ec;
  border: 1px solid #f5d96b;
  border-radius: var(--radius);
  padding: 0.85rem 1rem;
  animation: slideDown 0.3s ease;
}
@keyframes slideDown {
  from { opacity: 0; transform: translateY(-8px); }
  to { opacity: 1; transform: translateY(0); }
}
.banner-paw { font-size: 22px; flex-shrink: 0; }
.banner-text { flex: 1; font-size: 13px; color: var(--navy); line-height: 1.5; }
.banner-text strong { display: block; font-weight: 500; margin-bottom: 1px; }
.banner-btn {
  background: var(--navy); color: #fff; border: none; border-radius: var(--radius-sm);
  padding: 0.5rem 1rem; font-size: 13px; font-weight: 500; cursor: pointer;
  white-space: nowrap; font-family: 'DM Sans', sans-serif; transition: background 0.2s;
}
.banner-btn:hover { background: var(--gold); }
.banner-close {
  background: none; border: none; color: var(--muted); cursor: pointer;
  font-size: 16px; padding: 4px 6px; line-height: 1; border-radius: 4px; transition: background 0.15s;
}
.banner-close:hover { background: #f0e8d0; }

/* ─── SEARCH INFO ─── */
.search-info {
  background: var(--white);
  border: 1px solid var(--border);
  border-radius: var(--radius);
  padding: 0.75rem 1rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 0.85rem;
  color: var(--navy);
}
.search-count {
  color: var(--gold);
  font-weight: 500;
}

/* Skeleton loader */
.loading-state { display: flex; flex-direction: column; gap: 1.25rem; }
.loading-card {
  background: var(--white); border: 1px solid var(--border);
  border-radius: var(--radius); overflow: hidden; padding: 0.85rem 1rem;
}
.skel {
  background: linear-gradient(90deg, #f0ece4 25%, #fafaf8 50%, #f0ece4 75%);
  background-size: 200% 100%; animation: shimmer 1.4s infinite; border-radius: 6px;
}
.skel-header { height: 40px; margin-bottom: 0.75rem; }
.skel-img { height: 300px; border-radius: 0; margin: -1rem -1rem 0.75rem; }
.skel-text { height: 14px; margin-bottom: 8px; }
.skel-text.short { width: 60%; }
@keyframes shimmer { to { background-position: -200% 0; } }

/* Empty */
.empty-state { text-align: center; padding: 4rem 2rem; color: var(--muted); }
.empty-icon { font-size: 3rem; display: block; margin-bottom: 1rem; }
.empty-state p { font-size: 0.9rem; }

/* Error */
.alert-error {
  background: #fff0f0; color: #e05252; border: 1px solid #fcd4d4;
  padding: 0.8rem 1rem; border-radius: var(--radius-sm);
}

/* ─── POST CARD ─── */
.post-card {
  background: var(--white); border: 1px solid var(--border);
  border-radius: var(--radius); overflow: hidden; transition: box-shadow 0.2s;
}
.post-card:hover { box-shadow: 0 4px 20px rgba(0, 0, 0, 0.06); }

.post-header {
  display: flex; align-items: center; gap: 10px;
  padding: 0.85rem 1rem; cursor: pointer;
}
.avatar {
  width: 40px; height: 40px; border-radius: 50%; background: #fdf5e8;
  display: flex; align-items: center; justify-content: center; font-size: 20px;
  flex-shrink: 0; overflow: hidden; border: 1px solid var(--border);
}
.avatar img { width: 100%; height: 100%; object-fit: cover; }
.post-meta { flex: 1; }
.post-author { font-size: 13.5px; font-weight: 500; color: var(--navy); }
.post-location { font-size: 12px; color: var(--muted); display: flex; align-items: center; gap: 3px; }
.post-location svg {
  width: 11px; height: 11px; stroke: currentColor; fill: none; stroke-width: 2;
}
.post-more { color: var(--muted); cursor: pointer; padding: 4px; }
.post-more svg { width: 20px; height: 20px; stroke: currentColor; fill: none; stroke-width: 1.8; }

.post-image {
  width: 100%; aspect-ratio: 1/1; background: #fdf5e8;
  display: flex; align-items: center; justify-content: center;
  position: relative; overflow: hidden; cursor: pointer;
}
.post-image img { width: 100%; height: 100%; object-fit: cover; }
.post-image-placeholder { font-size: 80px; }

.post-badge {
  position: absolute; top: 12px; left: 12px; font-size: 10.5px; font-weight: 600;
  padding: 4px 10px; border-radius: var(--radius-full); letter-spacing: 0.05em;
}
.badge-both { background: var(--orange-bg); color: var(--orange-tag); }

/* Actions */
.post-actions { display: flex; align-items: center; gap: 2px; padding: 0.4rem 0.75rem 0; }
.action-save { margin-left: auto; }
.icon-btn {
  background: none; border: none; cursor: pointer; padding: 6px; color: var(--muted);
  border-radius: 6px; display: flex; align-items: center; justify-content: center;
  transition: color 0.15s;
}
.icon-btn svg {
  width: 22px; height: 22px; stroke: currentColor; fill: none; stroke-width: 1.8;
  stroke-linecap: round; stroke-linejoin: round; transition: fill 0.15s, stroke 0.15s;
}
.icon-btn:hover { color: var(--navy); }
.icon-btn.liked { color: #e05252; }
.icon-btn.liked svg { fill: #e05252; stroke: #e05252; }

.post-caption { padding: 0.2rem 1rem 0; font-size: 13px; color: #444; line-height: 1.5; cursor: pointer; }
.caption-name { font-weight: 500; color: var(--navy); margin-right: 4px; }
.post-desc { padding: 0.1rem 1rem 0; font-size: 12.5px; color: var(--muted); line-height: 1.55; cursor: pointer; }
.post-hashtags { padding: 0.15rem 1rem 0; font-size: 12.5px; color: var(--blue-tag); cursor: pointer; }
.post-time { padding: 0.15rem 1rem 0.75rem; font-size: 10.5px; color: #bbb; text-transform: uppercase; letter-spacing: 0.07em; cursor: pointer; }

/* ─── COMMENTAIRES DANS LE FEED ─── */
.comments-section-feed {
  padding: 0.75rem 1rem; background: #fafaf8;
  border-top: 1px solid var(--border); margin-top: 0.5rem;
}
.comments-list-feed { max-height: 300px; overflow-y: auto; margin-bottom: 0.75rem; }
.comment-item-feed { display: flex; gap: 10px; margin-bottom: 12px; }
.comment-avatar-feed {
  width: 32px; 
  height: 32px; 
  border-radius: 50%;
  background: linear-gradient(135deg, #f5d96b, #c8a84b);
  display: flex;
   align-items: center;
    justify-content: center;
  font-size: 12px; 
  font-weight: 700;
   color: white; flex-shrink: 0;
}
.comment-avatar-feed.small { width: 28px; 
height: 28px; 
font-size: 11px;
 }
.comment-bubble-feed {
  flex: 1;
   background: white; 
   border-radius: 12px;
  padding: 8px 12px; 
  border: 1px solid #e8e3d8;
}
.comment-header-feed { 
  display: flex; 
  justify-content: space-between; 
  align-items: center;
   margin-bottom: 4px; }
.comment-author-feed { 
  font-size: 11px;
   font-weight: 700; 
   color: var(--navy); }
.comment-date-feed { 
  font-size: 9px; 
  color: #bbb; }
.comment-text-feed { 
  font-size: 12px; 
  color: #555; 
  line-height: 1.4; 
  margin: 0; }
.no-comments-feed { 
  text-align: center;
   padding: 20px;
    color: #aaa;
     font-size: 12px; }
.no-comments-feed span { 
  font-size: 24px; 
  display: block;
   margin-bottom: 8px; }
.comment-input-feed {
  display: flex;
   align-items: center;
    gap: 10px;
  padding-top: 8px;
   border-top: 1px solid #e8e3d8;
}
.comment-input-feed input {
  flex: 1; 
  border: 1px solid #e8e3d8; 
  border-radius: 20px;
  padding: 8px 14px; 
  font-size: 12px;
   font-family: inherit;
  outline: none;
   transition: border-color 0.2s;
}
.comment-input-feed input:focus { border-color: #f5d96b; }
.comment-input-feed input:disabled {
   background: #f5f5f5; 
  cursor: pointer; }
.comment-send-btn {
  background: none; 
  border: none;
   color: var(--blue-tag); 
   font-size: 12px;
  font-weight: 600;
   cursor: pointer;
    padding: 6px 12px; 
    border-radius: 20px;
     transition: background 0.2s;
}
.comment-send-btn:hover:not(:disabled) { background: #e8f4ff; }
.comment-send-btn:disabled { opacity: 0.4;
 cursor: not-allowed; }
.comments-preview {
  padding: 8px 16px 12px; 
  font-size: 12px; 
  color: #888; 
  cursor: pointer;
   transition: color 0.2s;
}
.comments-preview:hover { color: var(--blue-tag); }


.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 1rem;
  padding: 0.75rem 0;
  border-top: 1px solid var(--border);
}
.page-btn {
  padding: 0.45rem 0.9rem;
  background: var(--white);
  border: 1px solid var(--border);
  border-radius: var(--radius-sm);
  cursor: pointer;
  font-size: 0.8rem;
  font-family: inherit;
  transition: all 0.2s;
}
.page-btn:hover:not(:disabled) {
  background: var(--navy);
  color: var(--white);
  border-color: var(--navy);
}
.page-btn:disabled {
  opacity: 0.4;
  cursor: not-allowed;
}
.page-info {
  font-size: 0.8rem;
  color: var(--muted);
}

/* ─── RIGHT SIDEBAR ─── */
.right-sidebar {
  border-left: 1px solid var(--border); background: var(--white);
  padding: 1.5rem 1.25rem; display: flex; flex-direction: column; gap: 1.5rem;
  position: sticky; top: 60px; height: calc(100vh - 60px);
  overflow-y: auto; scrollbar-width: none;
}
.right-sidebar::-webkit-scrollbar { display: none; }

.right-heading {
  font-family: 'Playfair Display', serif;
  font-size: 1rem;
  line-height: 1.2;
  color: #1a1a2e;
  margin-bottom: 10%;
}
.right-heading em { font-style: italic; color: #1a1a2e; }

.guest-cta {
  display: flex; flex-direction: column; gap: 10px;
  background: #fdf5e8; border: 1px solid var(--border);
  border-radius: var(--radius); padding: 1.25rem 1rem;
}
.guest-title { font-family: 'Playfair Display', serif; font-size: 16px; color: var(--navy); font-weight: 500; }
.guest-sub { font-size: 12.5px; color: var(--muted); line-height: 1.5; margin-bottom: 4px; }
.cta-btn {
  padding: 0.55rem 1rem; border-radius: var(--radius-sm); font-size: 13px; font-weight: 500;
  cursor: pointer; font-family: 'DM Sans', sans-serif; border: 1px solid var(--border);
  background: var(--white); color: var(--navy); transition: all 0.15s; text-align: center;
}
.cta-btn:hover { border-color: var(--navy); }
.cta-btn.primary { background: var(--navy); color: #fff; border-color: var(--navy); }
.cta-btn.primary:hover { background: var(--gold); border-color: var(--gold); }

.right-section { display: flex; flex-direction: column; }
.section-title { 
  font-size: 13px; 
  font-weight: 500; 
  color: var(--muted); 
  margin-bottom: 0.5rem;
  margin-top: -5%;
}

.stats-grid { 
  display: grid; 
  grid-template-columns: repeat(3, 1fr);
   gap: 8px; 
   margin-bottom: 15px;
   }
  
.stat-box {
  background: var(--bg); 
  border-radius: var(--radius-sm); 
  padding: 0.65rem 0.5rem;
  text-align: center; 
  border: 1px solid var(--border);
}
.stat-num { 
  font-size: 17px; 
  font-weight: 500; 
  color: var(--navy); 
}

.stat-lbl { 
  font-size: 10.5px; 
  color: var(--muted); 
  margin-top: 2px; 
}

.filter-btns { 
  display: flex; 
  flex-direction: column;
   gap: 6px; 
  }

.filter-pill {
  padding: 0.5rem 1rem; border: 1px solid var(--border); border-radius: var(--radius-full);
  background: var(--white); color: var(--muted); font-size: 13px; cursor: pointer;
  font-family: 'DM Sans', sans-serif; transition: all 0.15s; text-align: left;
}
.filter-pill:hover { border-color: var(--navy); color: var(--navy); }
.filter-pill.active { background: var(--navy); color: #fff; border-color: var(--navy); font-weight: 500; }

/* ─── NOUVEAUX STYLES POUR LES FILTRES DANS RIGHT SIDEBAR ─── */
.filter-scroll {
  max-height: 200px;
  overflow-y: auto;
  display: flex;
  flex-direction: column;
  gap: 6px;
}

.filter-chip {
  padding: 0.5rem 0.75rem;
  border: 1px solid var(--border);
  border-radius: var(--radius-sm);
  background: var(--white);
  color: var(--muted);
  font-size: 12px;
  cursor: pointer;
  font-family: 'DM Sans', sans-serif;
  transition: all 0.15s;
  text-align: left;
}

.filter-chip:hover {
  border-color: var(--navy);
  color: var(--navy);
}

.filter-chip.active {
  background: var(--navy);
  color: #fff;
  border-color: var(--navy);
  font-weight: 500;
}

.sort-btns {
  display: flex;
  flex-direction: column;
  gap: 6px;
}

.sort-chip {
  padding: 0.5rem 0.75rem;
  border: 1px solid var(--border);
  border-radius: var(--radius-sm);
  background: var(--white);
  color: var(--muted);
  font-size: 12px;
  cursor: pointer;
  font-family: 'DM Sans', sans-serif;
  transition: all 0.15s;
  text-align: left;
}

.sort-chip:hover {
  border-color: var(--navy);
  color: var(--navy);
}

.sort-chip.active {
  background: var(--navy);
  color: #fff;
  border-color: var(--navy);
  font-weight: 500;
}

.tag-pills { display: flex; flex-wrap: wrap; gap: 6px; }
.pill {
  font-size: 11.5px; padding: 5px 12px; border-radius: var(--radius-full);
  border: 1px solid var(--border); color: var(--muted); cursor: pointer; transition: all 0.15s;
}
.pill:hover { background: var(--navy); color: #fff; border-color: var(--navy); }

.footer-links { font-size: 11px; color: #ccc; line-height: 1.8; margin-top: auto; }

/* ─── MODALE AUTH ─── */
.modal-overlay {
  position: fixed; inset: 0; z-index: 1000; background: rgba(26, 26, 46, 0.55);
  display: flex; align-items: center; justify-content: center; animation: fadeIn 0.2s ease;
}
@keyframes fadeIn { from { opacity: 0; } to { opacity: 1; } }

.auth-modal {
  background: var(--white); border-radius: var(--radius); padding: 2rem 1.75rem;
  max-width: 360px; width: 90%; text-align: center;
  display: flex; flex-direction: column; gap: 12px; position: relative; animation: popIn 0.25s ease;
}
@keyframes popIn { from { transform: scale(0.95); opacity: 0; } to { transform: scale(1); opacity: 1; } }

.modal-x {
  position: absolute; top: 12px; right: 12px; background: none; border: none;
  font-size: 16px; color: var(--muted); cursor: pointer; padding: 4px 8px;
  border-radius: 4px; transition: background 0.15s;
}
.modal-x:hover { background: var(--bg); }

.auth-modal-paw { font-size: 40px; }
.auth-modal-title { font-family: 'Playfair Display', serif; color: var(--navy); font-size: 22px; margin: 0; font-weight: 500; }
.auth-modal-sub { font-size: 13.5px; color: var(--muted); margin: 0; line-height: 1.6; }
.auth-btn {
  padding: 0.7rem 1rem; border-radius: var(--radius-sm); font-size: 14px; font-weight: 500;
  cursor: pointer; font-family: 'DM Sans', sans-serif; border: 1px solid var(--border);
  background: var(--white); color: var(--navy); width: 100%; transition: all 0.15s;
}
.auth-btn:hover { border-color: var(--navy); }
.auth-btn.primary { background: var(--navy); color: #fff; border-color: var(--navy); }
.auth-btn.primary:hover { background: var(--gold); border-color: var(--gold); }
.auth-skip {
  background: none; border: none; color: var(--muted); font-size: 13px;
  cursor: pointer; font-family: 'DM Sans', sans-serif; text-decoration: underline; margin-top: 4px;
}
.auth-skip:hover { color: var(--navy); }

/* ─── RESPONSIVE ─── */
@media (max-width: 1000px) {
  .app-layout { grid-template-columns: 68px 1fr; }
  .right-sidebar { display: none; }
  .sidebar-inner { align-items: center; padding: 1.5rem 0.5rem; }
  .nav-item span, .post-btn span { display: none; }
  .nav-item { justify-content: center; padding: 0.65rem; }
  .post-btn { padding: 0.7rem; }
  .explorer-search { padding: 0; }
  .explorer-search-bar input { padding: 0.4rem 1.8rem 0.4rem 1.8rem; font-size: 0.7rem; }
  .search-icon-small { left: 0.6rem; }
  .clear-search-small { right: 0.6rem; }
}
@media (max-width: 600px) {
  .app-layout { grid-template-columns: 1fr; }
  .sidebar { display: none; }
  .feed { padding: 0.75rem 0; }
  .post-card { border-radius: 0; border-left: none; border-right: none; }
  .public-banner { border-radius: 0; border-left: none; border-right: none; }
}
</style>