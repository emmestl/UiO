possible = []


for i in range(1, 2):
    for j in range(i, 3):
        for k in range(j, 4):
            for l in range(k, 5):
                for m in range(l, 6):
                    for n in range(m, 7):
                        for o in range(n, 8):
                            for p in range(o, 9):
                                for q in range(p, 10):
                                    for r in range(q, 11):
                                        for s in range(r, 12):
                                            for t in range(s, 13):
                                                for u in range(t, 14):
                                                    for v in range(u, 15):
                                                        for w in range(v, 16):
                                                            for x in range(w, 17):

                                                                possible.append([w,x])
                                                                possible.append([v,w,x])
                                                                possible.append([u, v, w,x])
                                                                possible.append([t, u, v, w, x])
                                                                possible.append([s, t, u, v, w,x])
                                                                possible.append([r, s, t, u, v,w,x])
                                                                possible.append([q, r, s, t, u, v, w,x])
                                                                possible.append([p, q, r, s, t, u, v,w,x])
                                                                possible.append([o, p, q, r, s, t, u, v, w,x])
                                                                possible.append([n, o, p, q, r, s, t, u, v,w,x])
                                                                possible.append([m, n, o, p, q, r, s, t, u, v, w,x])
                                                                possible.append([l, m, n, o, p, q, r, s, t, u, v,w,x])
                                                                possible.append([k, l, m, n, o, p, q, r, s, t, u, v,w,x])
                                                                possible.append([j, k, l, m, n, o, p, q, r, s, t, u, v,w,x])
                                                                possible.append([i, j, k, l, m, n, o, p, q, r, s, t, u, v,w,x])

print len(possible)
