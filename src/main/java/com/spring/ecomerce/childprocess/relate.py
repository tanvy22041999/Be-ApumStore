import sys
import json
import requests
import numpy as np
import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import linear_kernel

url = 'https://be-ecommerce-production.up.railway.app/products/cluster'
r = requests.get(url)
data = r.json()

products = pd.DataFrame(data['products'])
products = products.dropna()

tf = TfidfVectorizer(analyzer='word',ngram_range=(1, 2),min_df=0)
tfidf_matrix = tf.fit_transform(products['desc_text'])

cosine_sim = linear_kernel(tfidf_matrix, tfidf_matrix)

products=products.reset_index()

names = products['name']
_ids = products['_id']
indices = pd.Series(products.index, index = products['_id'])             index


def get_recommendations(title):
    idx = indices[title]
    sim_scores = list(enumerate(cosine_sim[idx]))
    sim_scores = sorted(sim_scores, key=lambda x: x[1], reverse=True)
    sim_scores = sim_scores[1:5]
    movie_indices = [i[0] for i in sim_scores]
    return _ids.iloc[movie_indices]

res = get_recommendations(sys.argv[1])   

resp = {
  "data": res.tolist()
}
print(json.dumps(resp))
sys.stdout.flush()