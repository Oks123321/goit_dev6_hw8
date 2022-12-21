
INSERT INTO public.roles (id, role) VALUES ('4a89329f-5dcb-4090-b246-dae7800c4928', 'ROLE_USER');
INSERT INTO public.roles (id, role) VALUES ('c75c0d64-e8bd-4489-aedc-f3888dfc278a', 'ROLE_ADMIN');

INSERT INTO public.users (id, email, password, first_name, last_name)
VALUES ('e95c01cc-bdb3-42ae-a57d-d71d6b1f56ca', 'admin@test.com', '$2a$10$63GAffXSkhqYsStMCIynhOGs7UTvXNSKK4p6F6R5rV4MK4lN71byS', 'Admin', 'Admin');

INSERT INTO public.userroles (role_id, user_id)
VALUES ('4a89329f-5dcb-4090-b246-dae7800c4928', 'e95c01cc-bdb3-42ae-a57d-d71d6b1f56ca');
INSERT INTO public.userroles (role_id, user_id)
VALUES ('c75c0d64-e8bd-4489-aedc-f3888dfc278a', 'e95c01cc-bdb3-42ae-a57d-d71d6b1f56ca');

INSERT INTO public.producers (id, name)
VALUES ('0e58c338-9ebd-49b1-ac47-8fb6a2c0d688', 'Agricultural Company');
INSERT INTO public.producers (id, name)
VALUES ('e5776711-8196-4e05-a7be-db460501f943', 'Agrics');
INSERT INTO public.producers (id, name)
VALUES ('67d54871-5065-4e98-96ca-ca40e043c03c', 'Grais Agro');
INSERT INTO public.producers (id, name)
VALUES ('74a5b238-dc1f-4ce7-8e5b-55354f3a3332', 'Ecofol');

INSERT INTO public.products (id, name, price, producer_id)
VALUES ('4d642bb4-1ebd-4415-98aa-b9cfa90f3e10', 'Lactofol', 50.00, '74a5b238-dc1f-4ce7-8e5b-55354f3a3332');
INSERT INTO public.products (id, name, price, producer_id)
VALUES ('8c4f10f1-3623-4fe2-acd7-3ef2ca9dd542', 'Amino Expert', 45.00, '74a5b238-dc1f-4ce7-8e5b-55354f3a3332');
